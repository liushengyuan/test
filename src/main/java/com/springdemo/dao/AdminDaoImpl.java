package com.springdemo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springdemo.po.Admin;
public interface AdminDaoImpl {
	public List<Admin> checkAdminUsername(String username,String password);
}
