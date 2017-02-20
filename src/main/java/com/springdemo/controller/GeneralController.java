package com.springdemo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller  
public class GeneralController {  
  
  
    //浏览器访问 http://localhost:8080/springmvc/index
    @RequestMapping(value="/index") 
    public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest httpServletRequest,
            javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {

    	ModelAndView mv = new ModelAndView();
    	//封装要显示到视图的数据
    	mv.addObject("jiafuwei","Hello");
    	//视图名
    	mv.setViewName("index");
    	System.out.println("index.jsp");
    	return mv;
	
	}
} 