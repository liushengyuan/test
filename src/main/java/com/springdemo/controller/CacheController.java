package com.springdemo.controller;



import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springdemo.service.EhCacheTestService;

@Controller  
@RequestMapping("cacheTest")
public class CacheController {  
	
	
	@Autowired  
    private EhCacheTestService ehCacheTestService;

	@RequestMapping(value="/cache") 
    public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest httpServletRequest,
            javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {

		System.out.println("第一次调用：" + ehCacheTestService.getTimestamp("param"));
        Thread.sleep(2000);
        System.out.println("2秒之后调用：" + ehCacheTestService.getTimestamp("param"));
        Thread.sleep(11000);
        System.out.println("再过11秒之后调用：" + ehCacheTestService.getTimestamp("param"));
		
    	ModelAndView mv = new ModelAndView();
    	//封装要显示到视图的数据
    	mv.addObject("jiafuwei","Hello");
    	//视图名
    	mv.setViewName("index");
    	System.out.println("index.jsp");
    	return mv;
	
	}
    
	
} 