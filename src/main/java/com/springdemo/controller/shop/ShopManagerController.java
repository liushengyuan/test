package com.springdemo.controller.shop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springdemo.po.Order;
import com.springdemo.service.ActService;
import com.springdemo.service.OrderService;

@Controller
@RequestMapping("/shop")
public class ShopManagerController {
	@Autowired 
	private ActService actserviceimpl;
	@Autowired 
	private OrderService orderserviceimpl;
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
}
