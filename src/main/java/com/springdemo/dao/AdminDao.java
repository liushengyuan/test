package com.springdemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springdemo.po.Admin;
@Repository 
public class AdminDao implements AdminDaoImpl {
	
	@Autowired 
	private JdbcTemplate jdbcTemplate; 
	@SuppressWarnings("deprecation")
	@Autowired
	private SimpleJdbcTemplate simpleJdbcTemplate;
	
	@Override
	public List<Admin>  checkAdminUsername(String username, String password) {
		// TODO Auto-generated method stub
		String sql="select * from admin where username= ?";
		
		@SuppressWarnings("deprecation")
		List<Admin> list = this.simpleJdbcTemplate.query(sql,
				ParameterizedBeanPropertyRowMapper.newInstance(Admin.class), username);
		
		return list;
	}

}
