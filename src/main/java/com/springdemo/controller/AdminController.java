package com.springdemo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.springdemo.po.Admin;
import com.springdemo.service.AdminUserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	 @Autowired  
	 private AdminUserService adminUser; 
	 
	 @RequestMapping("/isLogin")
	 
	 public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest httpServletRequest,
	            javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
		 	
		 	//获取session中的登陆对象
			HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
			Admin admin =(Admin) request.getSession().getAttribute("adminUser");
	    	ModelAndView mv = new ModelAndView();
	    	
	    	//判断后台管理员是否登陆
	    	if(admin==null){
	    	 	//视图名
	    		mv.setViewName("login");
	    	}else{
	    		mv.addObject("adminUser",admin);
	    		mv.setViewName("index");
	    	}
	    	return mv;
		
		}
	 /**
	  * 后台登陆
	  * @param username
	  * @param password
	  * @return
	  */
	 @RequestMapping(value="/login",produces = "application/json; charset=utf-8")
	 @ResponseBody
	 public String adminLogin(@RequestParam("username") String username,@RequestParam("password") String password){
		 String usernameError= "用户名不正确！";
		 String loginError = "密码不正确！";
		 //登陆方法
		 Admin admin =adminUser.login(username, password);
		 //返回值
		 if(admin!=null){
			 if(admin.getPassword().equals(password)){
				 //获取request对象
				 HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
				 request.getSession().setAttribute("adminUser", admin);
				 //进行json封装
				 Gson gson = new Gson();
				 String json = gson.toJson(admin.getUsername());
				 return json; 
			 }else{
				 return loginError;
			 }
			
		 }else{
			 return usernameError;
		 }
	 }
	 /**
	  * 退出登陆
	  * 
	  */
	 @RequestMapping(value="/logout")
	 public String logout(){
		 HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
		 request.getSession().setAttribute("adminUser","");
		 return "login";
	 }
}
