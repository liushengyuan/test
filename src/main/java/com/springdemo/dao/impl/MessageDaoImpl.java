package com.springdemo.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springdemo.dao.MessageDao;
import com.springdemo.po.MemberMessage;

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

	@Override
	public void addMessage(MemberMessage message) {
		// TODO Auto-generated method stub
		String sql="insert into member_message (member_name,message,member_email,member_phone) values (?,?,?,?)";
		this.simpleJdbcTemplate.update(sql, message.getMember_name(),message.getMessage(),message.getMember_email(),message.getMember_phone());
	}

}
