package com.springdemo.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springdemo.dao.MessageDao;

@SuppressWarnings("deprecation")
@Repository 
public class MessageDaoImpl implements MessageDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate; 
	
	@Autowired
	private SimpleJdbcTemplate simpleJdbcTemplate;
	
	@Override
	public void removeMessage(int id) {
		// TODO Auto-generated method stub
		String sql="delete from member_message where id="+id;
		this.simpleJdbcTemplate.update(sql);
		
	}

}
