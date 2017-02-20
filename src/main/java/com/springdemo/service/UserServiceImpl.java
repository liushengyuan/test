package com.springdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdemo.dao.UserDao;
import com.springdemo.po.User;

@Service  
public class UserServiceImpl implements IUserService {  
  
    @Autowired  
    private UserDao userDao;  
      
    @Override  
    public User loginCheck(User user) {  
        User u  = userDao.findUserByUserName("user.getUserName()");  
        //System.out.println("id="+u.getId()+",  userName="+u.getUserName()+", password="+u.getPassword());  
        if(user.getPassword().equals(u.getPassword())){  
            return u;  
        }  
        else{  
            return null;  
        }  
    }  
  
    @Override  
    public boolean register(User user) {  
        User u =  userDao.findUserByUserName("174");  
        System.out.println(u);
        return true;  
    }  
  
}  
