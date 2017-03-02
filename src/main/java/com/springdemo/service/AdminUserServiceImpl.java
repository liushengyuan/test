package com.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdemo.dao.AdminDaoImpl;
import com.springdemo.po.Admin;

@Service
public class AdminUserServiceImpl implements AdminUserService {
	
	@Autowired
	private AdminDaoImpl admindao;
	
	@Override
	public Admin login(String username, String password) {
		// TODO Auto-generated method stub
		List<Admin> list = this.admindao.checkAdminUsername(username, password);
		if(list.size()>0){
			Admin admin =list.get(0);
			return admin;
		}
		return null;
	}
}
