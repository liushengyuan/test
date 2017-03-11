package com.springdemo.controller.shop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.springdemo.po.Goods;
import com.springdemo.po.Order;
import com.springdemo.service.ActService;
import com.springdemo.service.GoodsService;
import com.springdemo.service.OrderService;
import com.springdemo.service.SeachService;

@Controller
public class ShopManagerController {
	@Autowired 
	private ActService actserviceimpl;
	@Autowired 
	private OrderService orderserviceimpl;
	@Autowired
	private GoodsService goodsserviceimpl;
	@Autowired
	private SeachService seachserviceimpl;
		//获得活动列表
		@RequestMapping(value="/getActList",produces = "application/json; charset=utf-8")
		public ModelAndView getActList(){
			ModelAndView mv = new ModelAndView();
			try {
				List actGoodsList =this.actserviceimpl.getActGoods();
				mv.addObject("actGoodsList",actGoodsList);
				mv.setViewName("../../index");
		        return mv;
			} catch (Exception e) {
				// TODO: handle exception
				return mv;
			}
		}
		//添加订单
		@RequestMapping(value="/addOrder",produces = "application/json; charset=utf-8")
		public String addOrder(){
			try {
				Order order = new Order();
				this.orderserviceimpl.addOrder(order);
				return "下订单成功";
			} catch (Exception e) {
				// TODO: handle exception
				return "网络错误";
			}
		}
		//查看商品详情
		@RequestMapping(value="/getGoodsInfo",produces = "application/json; charset=utf-8")
		public ModelAndView getGoodsInfo(@RequestParam(value = "goods_id", required = false, defaultValue = "") Integer goods_id){
			ModelAndView mv = new ModelAndView();
			try {
			List<Goods>	list =this.goodsserviceimpl.getGoodsInfo(goods_id);
			if(list.get(0)!=null){
				if(list.get(0).getImage1()!=""){
					String url2 ="/springmvc"+list.get(0).getImage1().split("springmvc")[1];
					list.get(0).setImage1(url2);
				}
				if(list.get(0).getImage3()!=""){
					String url2 ="/springmvc"+list.get(0).getImage3().split("springmvc")[1];
					list.get(0).setImage2(url2);
				}
				if(list.get(0).getImage3()!=""){
					String url2 ="/springmvc"+list.get(0).getImage3().split("springmvc")[1];
					list.get(0).setImage3(url2);
				}
				mv.addObject("goodsinfo",list.get(0));
				
			}
				mv.setViewName("../../shop/single");
				return mv;
			} catch (Exception e) {
				// TODO: handle exception
				mv.setViewName("../../shop/single");
				return mv;
			}
		}
		//搜索
		@RequestMapping("/getSeach")
		@ResponseBody
		public String getSeach(@RequestParam(value = "cla", required = false, defaultValue = "") Integer cla,
				@RequestParam(value = "child_cla", required = false, defaultValue = "") Integer child_cla,
				@RequestParam(value = "three_cla", required = false, defaultValue = "") Integer three_cla,
				@RequestParam(value = "keyword", required = false, defaultValue = "") String keyword){
			
			List goodsList = this.seachserviceimpl.getSeachGoodsList(cla, child_cla, three_cla, keyword);
			Gson gson = new Gson();
			String json = gson.toJson(goodsList);
			return json;
		}
}
