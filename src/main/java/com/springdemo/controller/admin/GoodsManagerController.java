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
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.springdemo.po.Admin;
import com.springdemo.po.Goods;
import com.springdemo.po.Goodscla;
import com.springdemo.po.Page;
import com.springdemo.service.GoodsService;


@Controller
@RequestMapping("/admin")
public class GoodsManagerController {
	
	@Autowired 
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private GoodsService goodsService;
	
	//添加商品跳转
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
		Goodscla goodsCla = new Goodscla();
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		//获取参数
		try {
			String goodsname =request.getParameter("goodsname");
			String price = request.getParameter("price");
			String childClass =request.getParameter("childClass");
			String class2 = request.getParameter("class2");
			String threeClass =request.getParameter("threeClass");
			String info = request.getParameter("info");
			String radio = request.getParameter("radio");
			goods.setGoods_name(goodsname);
			goods.setImage1(image1);
			goods.setImage2(image2);
			goods.setImage3(image3);
			goods.setInfo(info);
			goods.setIs_check(Integer.valueOf(radio));
			goods.setPrice(Double.valueOf(price));
			//添加商品
			this.goodsService.addGoods(goods);
			//查询刚添加商品的id
			int goods_id =this.goodsService.lastGoodsid();
			//添加分类
			goodsCla.setCla(Integer.valueOf(class2));
			goodsCla.setChild_cla(Integer.valueOf(childClass));
			goodsCla.setThree_cla(Integer.valueOf(threeClass));
			goodsCla.setGoods_id(Integer.valueOf(goods_id));
			this.goodsService.addGoodscla(goodsCla);
			return "上传成功";
		} catch (Exception e) {
			return "网络出现问题！";
		}
		
	}
	//后台查询商品列表
	@RequestMapping(value = "/getGoodsControll",produces = "application/json; charset=utf-8")
	public ModelAndView getGoodsPage(@RequestParam("page") String page,@RequestParam("pageSize") String pageSize){
		if(page==""||page==null){
			page="1";
			pageSize="15";
		}
		int pageNo=Integer.valueOf(page);
		int pageSizeNum =Integer.valueOf(pageSize);
		Page goodsPage =this.goodsService.getGoodsPage(pageNo, pageSizeNum);
		ModelAndView mv = new ModelAndView();
		mv.addObject("goodsPage",goodsPage);
		mv.setViewName("admin/goods/goods_list");
		
		return mv;
	}
	//下架商品
	@RequestMapping("/delGoods")
	public ModelAndView delGoods(@RequestParam("goods_id") int goods_id){
		this.goodsService.changeGoods(goods_id, 0);
		
		this.getGoodsPage("1", "3");
		return this.getGoodsPage("1", "3");
	}
	//上架商品
	@RequestMapping("/addGoodsChange")
	public ModelAndView addGoods(@RequestParam("goods_id") int goods_id){
		this.goodsService.changeGoods(goods_id, 1);
		this.getGoodsPage("1", "3");
		return this.getGoodsPage("1", "3");
	}
}
