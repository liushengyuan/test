package com.springdemo.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.springdemo.service.SeachService;

@Controller
public class SeachManagerController {
	
	@Autowired
	private SeachService seachserviceimpl;
	
	@RequestMapping("/getSeachList")
	@ResponseBody
	public ModelAndView getSeachList(@RequestParam(value = "cla", required = false, defaultValue = "") Integer cla,
			@RequestParam(value = "child_cla", required = false, defaultValue = "") Integer child_cla,
			@RequestParam(value = "three_cla", required = false, defaultValue = "") Integer three_cla,
			@RequestParam(value = "keyword", required = false, defaultValue = "") String keyword){
		
		List goodsList = this.seachserviceimpl.getSeachGoodsList(cla, child_cla, three_cla, keyword);
		ModelAndView mv = new ModelAndView();
		mv.addObject("goodsList",goodsList);
		mv.setViewName("../../shop/products");
		return mv;
	}
}
