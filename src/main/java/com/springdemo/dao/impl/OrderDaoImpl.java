package com.springdemo.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springdemo.dao.OrderDao;
import com.springdemo.po.Order;

@SuppressWarnings("deprecation")
@Repository 
public class OrderDaoImpl implements OrderDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private SimpleJdbcTemplate simpleJdbcTemplate;
	
	@Override
	public void addOrder(Order order) {
		// TODO Auto-generated method stub
		String sql="insert into order(cat_id,code,member_id,time,status,address,phone) values(?,?,?,?,?,?,?)";
		this.simpleJdbcTemplate.update(sql, order.getCat_id(),order.getCode(),order.getMember_id(),order.getTime(),order.getStatus(),order.getAddress(),order.getPhone());
	}

}
