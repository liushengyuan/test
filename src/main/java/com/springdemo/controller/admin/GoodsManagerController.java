package com.springdemo.controller.admin;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/admin")
public class GoodsManagerController {
	@RequestMapping("/addGoods")
	public String addGoods(Model model){
		return "admin/goods/add_goods";
	}
	@RequestMapping("/goodsList")
	public String goodsList(Model model){
		return "admin/goods/goods_list";
	}
	

}
