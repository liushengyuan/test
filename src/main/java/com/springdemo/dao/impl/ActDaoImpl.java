package com.springdemo.dao.impl;

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

}
