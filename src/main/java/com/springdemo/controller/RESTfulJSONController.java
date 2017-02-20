package com.springdemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.springdemo.po.User;

@Controller
@RequestMapping("/user")
public class RESTfulJSONController {

	//访问路径 http://localhost:8080/springmvc/user/view/jiafuwei
    /**Spring MVC RESTful JSON**/
    @RequestMapping(value = "/view/{username}", method = RequestMethod.GET)
    @ResponseBody
    public User view(@PathVariable String username){
    	User user = new User();
    	user.setAge(10);
    	user.setEmail("jiafuwei@qq.com");
    	user.setPassword("123");
    	user.setUsername(username);
        System.out.println("view username:"+username);

        return user;
    }

    //访问路径  http://localhost:8080/springmvc/user/query?username=jiahaha
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ResponseBody
    public User query(@RequestParam(value="username", required=true) String username){
    	User user = new User();
    	user.setAge(10);
    	user.setEmail("jiafuwei@qq.com");
    	user.setPassword("123");
    	user.setUsername(username);
        System.out.println("view username:"+username);

        return user;
    }

    @RequestMapping(value = "/gson", method = RequestMethod.GET)
    @ResponseBody
    public String gson(@RequestParam(value="username", required=true) String username){
    	User user = new User();
    	user.setAge(10);
    	user.setEmail("jiafuwei@qq.com");
    	user.setPassword("123");
    	user.setUsername(username);
        System.out.println("view username:"+username);
        Gson gson = new Gson();
		String json = gson.toJson(user);
        return json;
    }
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody
	List<User> listPerson(@RequestParam(value = "username", required = false, defaultValue = "") String name) {

    	User user = new User();
    	user.setAge(10);
    	user.setEmail("jiafuwei@qq.com");
    	user.setPassword("123");
    	user.setUsername("haha");
    	
    	User user2 = new User();
    	user2.setAge(50);
    	user2.setEmail("tyew@qq.com");
    	user2.setPassword("frekkk");
    	user2.setUsername("zheshi");
    	
		List<User> listUser = new ArrayList<User>();
		listUser.add(user);
		listUser.add(user2);
		

		return listUser;
	}
    
}