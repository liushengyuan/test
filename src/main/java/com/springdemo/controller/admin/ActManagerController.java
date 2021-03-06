package com.springdemo.controller.admin;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.springdemo.dao.PageDao;
import com.springdemo.po.Page;
import com.springdemo.service.ActService;

@SuppressWarnings("deprecation")
@Controller
@RequestMapping("/admin")
public class ActManagerController {
	
	@Autowired 
	private ActService actserviceimpl;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private SimpleJdbcTemplate simpleJdbcTemplate;
	@Autowired
	private PageDao pagedaoimpl;
	
	//获得活动列表
	@RequestMapping("/getAct")
	public ModelAndView getAct(){
		String sql="select * from act";
		List<Map<String, Object>> actList =this.jdbcTemplate.queryForList(sql);
		ModelAndView mv = new ModelAndView();
		mv.addObject("actList",actList.get(0));
		//活动展示页面名称
		mv.setViewName("admin/active/act_list");
		return mv;
	}
	
	//获得活动关联的商品
	@RequestMapping("/getActGoods")
	public ModelAndView getActGoods(@RequestParam("act_id") int act_id,@RequestParam("page")int page,@RequestParam("pageSize")int pageSize){
		ModelAndView mv = new ModelAndView();
		Page ActGoods = this.pagedaoimpl.getActGoodsList(page, pageSize, act_id);
		mv.addObject("ActGoods",ActGoods);
		mv.addObject("act_id",act_id);
		mv.setViewName("admin/active/act_goods");
		return mv;
	}
	
	//删除活动关联的商品
	@RequestMapping(value="/delActGoods",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String delActGoods(@RequestParam("goods_id") int goods_id,@RequestParam("act_id") int act_id){
		try {
			this.actserviceimpl.delActGoods(act_id, goods_id);
			return "删除关联商品成功";
		} catch (Exception e) {
			// TODO: handle exception
			return "删除关联商品失败";
		}
	}
	//获取活动没有关联的商品
	@RequestMapping("/getNoActGoods")
	public ModelAndView getNoActGoods(@RequestParam("act_id") int act_id,@RequestParam("page")int page,@RequestParam("pageSize")int pageSize)
	{
		ModelAndView mv = new ModelAndView();
		Page ActNoGoods =this.pagedaoimpl.getNoActGoods(page, pageSize, act_id);
		mv.addObject("ActNoGoods",ActNoGoods);
		mv.addObject("act_id",act_id);
		mv.setViewName("admin/active/act_nogoods");
		return mv;
	}
	
	//添加活动关联的商品
	@RequestMapping(value="/addActGoods",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String  addActGoods(@RequestParam("goods_id") int goods_id,@RequestParam("act_id") int act_id){
		try {
			this.actserviceimpl.addActGoods(act_id, goods_id);
			return "关联商品成功";
		} catch (Exception e) {
			// TODO: handle exception
			return "网络错误！请重试";
		}
	}
	//获得活动列表
	@RequestMapping(value="/getActList",produces = "application/json; charset=utf-8")
	public ModelAndView getActList(){
		ModelAndView mv = new ModelAndView();
		try {
			List actGoodsList =this.actserviceimpl.getActGoods();
			mv.addObject("actGoodsList",actGoodsList);
			mv.setViewName("../../index.jsp");
	        return mv;
		} catch (Exception e) {
			// TODO: handle exception
			return mv;
		}
	}
}
