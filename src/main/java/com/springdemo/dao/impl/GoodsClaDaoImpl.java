package com.springdemo.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springdemo.dao.GoodsClaDao;
@SuppressWarnings("deprecation")
@Repository 
public class GoodsClaDaoImpl implements GoodsClaDao{
	

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private SimpleJdbcTemplate simpleJdbcTemplate;
	
	@Override
	public List getGoodsCla(Integer cla, Integer child_cla, Integer three_cla,String keyword) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM goods where is_check=1");
		if(cla!=null){
			sql.append(" and id in (select goods_id from goodscla where cla="+cla+")");
		}
		if(child_cla!=null){
			sql.append(" and id in (select goods_id from goodscla where child_cla="+child_cla+")");
		}
		if(three_cla!=null){
			sql.append(" and id in (select goods_id from goodscla where three_cla="+three_cla+")");
		}
		if(keyword==null||"".equals(keyword)){
			List goodsList = this.simpleJdbcTemplate.queryForList(sql.toString());
			return goodsList;
		}else{
			sql.append(" and goods_name like %"+keyword+"%");
			List goodsList = this.simpleJdbcTemplate.queryForList(sql.toString());
			return goodsList;
		}
		
	}

}
