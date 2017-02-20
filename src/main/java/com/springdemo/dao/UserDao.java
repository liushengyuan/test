package com.springdemo.dao;

import com.springdemo.po.User;

public interface UserDao {  
    public void register(User user);  
    public User findUserByUserName(final String userName);  
} 