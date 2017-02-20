package com.springdemo.service;

import com.springdemo.po.User;

public interface  IUserService {
	public boolean register(User user);  
    public User loginCheck(User user);
}
