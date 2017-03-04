package com.springdemo.controller.admin;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.springdemo.po.Admin;


@Controller
@RequestMapping("/admin")
public class GoodsManagerController {
	@Autowired 
	private JdbcTemplate jdbcTemplate;
	//添加商品
	@RequestMapping("/addGoods")
	public String addGoods(Model model){
		return "admin/goods/add_goods";
	}
	//商品列表
	@RequestMapping("/goodsList")
	public String goodsList(Model model){
		return "admin/goods/goods_list";
	}
	//获得分类
	@RequestMapping(value = "/getClass",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String getClass(@RequestParam("child") int child){
		String childs="";
		System.out.println(child);
		if(child==0){
			childs="上衣";
		}else if(child==1){
			childs="裤子";
		}else if(child==2){
			childs="鞋子";
		}else{
			return "网路错误！";
		}
		String sql="select * from child_cla where child_cla= ?";
		List<Map<String, Object>> list = this.jdbcTemplate.queryForList(sql,childs);
		 Gson gson = new Gson();
		 String json = gson.toJson(list);
		 return json; 
	}

}
