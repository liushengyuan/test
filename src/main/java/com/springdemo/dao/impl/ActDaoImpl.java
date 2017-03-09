package com.springdemo.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springdemo.dao.ActDao;
@SuppressWarnings("deprecation")
@Repository 
public class ActDaoImpl implements ActDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private SimpleJdbcTemplate simpleJdbcTemplate;
	
	@Override
	public void addActGoods(int act_id, int goods_id) {
		// TODO Auto-generated method stub
		String sql = "insert into act_goods(act_id,goods_id) values(?,?)";
		this.simpleJdbcTemplate.update(sql, act_id,goods_id);
	}

	@Override
	public void delActGoods(int act_id, int goods_id) {
		// TODO Auto-generated method stub
		String sql = "delete from act_goods where act_id = ? and goods_id =?";
		this.simpleJdbcTemplate.update(sql, act_id,goods_id);
	}

	@Override
	public List getActGoodsList() {
		// TODO Auto-generated method stub
		//获得显示活动的id
		String sql="select id from act where status=1";
		int id =this.simpleJdbcTemplate.queryForInt(sql);
		//根据 id获取活动商品列表
		String sql2 ="select * from  goods where id in(select goods_id from act_goods where act_id="+id+")";
		List actGoodsList =this.simpleJdbcTemplate.queryForList(sql2);
		return actGoodsList;
	}

}
