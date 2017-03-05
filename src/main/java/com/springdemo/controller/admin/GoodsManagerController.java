package com.springdemo.controller.admin;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.google.gson.Gson;
import com.springdemo.po.Admin;
import com.springdemo.po.Goods;


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
	//添加商品
	@RequestMapping(value = "/addGoodsControll",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String addGoods(@RequestParam("image1") String image1,@RequestParam("image3") String image3,@RequestParam("image2") String image2){
		Goods goods= new Goods();
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		//获取参数
		String goodsname =request.getParameter("goodsname");
		String price = request.getParameter("price");
		String childClass =request.getParameter("childClass");
		String class2 = request.getParameter("class2");
		String threeClass =request.getParameter("threeClass");
		String info = request.getParameter("info");
		String radio = request.getParameter("radio");
		goods.setGoods_name(goodsname);
		goods.setImage1(image1);
		goods.setImage1(image2);
		goods.setImage1(image3);
		goods.setInfo(info);
		goods.setIs_check(Integer.valueOf(radio));
		goods.setPrice(Double.valueOf(price));
		//添加商品
		
		//添加分类
		
		/*System.out.println(goodsJson);*/
		return "hh";
	}
}
