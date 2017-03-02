package com.springdemo.controller;


import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springdemo.po.User;
import com.springdemo.service.IUserService;

@Controller  
public class SpringJDBCController {  
	//@Autowired 
    public JdbcTemplate jdbcTemplate;

	@Autowired  
    private IUserService userService; 
  
    //浏览器访问 http://localhost:8080/springmvc/index
    @RequestMapping(value="/jdbc") 
    public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest httpServletRequest,
            javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
    	String sql = "SELECT uname FROM es_member WHERE member_id = 174";
    	String uname = jdbcTemplate.queryForObject(sql, String.class);
    	System.out.println(uname);
    	
    	ModelAndView mv = new ModelAndView();
    	//封装要显示到视图的数据
    	mv.addObject("jiafuwei",uname);
    	//视图名
    	mv.setViewName("index");
    	System.out.println("index.jsp");
    	return mv;
	
	}
    
    @RequestMapping(value="/user") 
    public ModelAndView user(javax.servlet.http.HttpServletRequest httpServletRequest,
            javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
    	User user = new User();
    	userService.register(user);
    	
    	ModelAndView mv = new ModelAndView();
    	//封装要显示到视图的数据
    	mv.addObject("jiafuwei","user");
    	//视图名
    	mv.setViewName("index");
    	System.out.println("index.jsp");
    	return mv;
	
	}
} 