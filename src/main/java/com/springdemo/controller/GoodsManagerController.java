package com.springdemo.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/goods")
public class GoodsManagerController {
	@RequestMapping("/addGoods")
	public String addGoods(Model model){
		model.addAttribute("addr", "admin/goods/goods_list.jsp");
		model.addAttribute("addrStyle", "02");
		return "index";
	}

}
