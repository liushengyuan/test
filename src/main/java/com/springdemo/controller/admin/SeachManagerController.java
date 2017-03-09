package com.springdemo.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springdemo.service.SeachService;

@Controller
@RequestMapping("/seach")
public class SeachManagerController {
	
	@Autowired
	private SeachService seachserviceimpl;
	
	@RequestMapping("/getSeachList")
	@ResponseBody
	public String getSeachList(){
		return "";
	}
}
