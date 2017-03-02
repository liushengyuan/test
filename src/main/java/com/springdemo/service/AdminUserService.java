package com.springdemo.service;

import com.springdemo.po.Admin;

public interface AdminUserService {
	public Admin login(String username,String password);
}
