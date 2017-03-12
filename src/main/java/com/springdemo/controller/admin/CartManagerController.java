package com.springdemo.controller.admin;

import java.awt.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.springdemo.po.Cart;
import com.springdemo.po.Member;
import com.springdemo.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartManagerController {
	
	@Autowired
	private CartService cartserviceimpl;
	private int goods_id;
	private int member_id;
	private int num;
	
	//删除购物车的一个商品
	@RequestMapping(value="/delCartGoods",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String delCartGoods(){
		try {
			this.cartserviceimpl.delCartGoods(goods_id, member_id);
			return "";
		} catch (Exception e) {
			// TODO: handle exception
			return "网络错误！";
		}
	}
	
	//删除购物车的所有商品
	@RequestMapping(value="/delAllCartGoods",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String delAllCartGoods(){
		try {
			this.cartserviceimpl.delAllCartGoods(goods_id);
			return "";
		} catch (Exception e) {
			// TODO: handle exception
			return "网络错误！";
		}
	}
	
	//减少购物车一个商品的数量
	@RequestMapping(value="/downCartGoods",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String downCartGoods(){
		try {
			this.cartserviceimpl.dowmCartGood(member_id, goods_id, num);
			return "";
		} catch (Exception e) {
			// TODO: handle exception
			return "网络错误！";
		}
	}
	
	//增加购物车一个商品的数量
	@RequestMapping(value="/addCartGoods",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String addCartGoods(){
		try {
			this.cartserviceimpl.addCartGood(member_id, goods_id, num);
			return "";
		} catch (Exception e) {
			// TODO: handle exception
			return "网络错误！";
		}
	}
	
	
	//加入购物车
	@RequestMapping(value="/addCart",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String addCart(){
		try {
			Cart cart = new Cart();
			HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
			String id =request.getParameter("id");
			String price =request.getParameter("price");
			String goods_name =request.getParameter("goods_name");
			String goods_image1 =request.getParameter("goods_image1");
			cart.setGoods_id(Integer.parseInt(id));
			cart.setGoods_image1(goods_image1);
			cart.setGoods_name(goods_name);
			cart.setGoods_price(Integer.parseInt(price));
			Member member =(Member) request.getSession().getAttribute("member");
			cart.setIs_select(1);
			cart.setNum(1);
			if(member!=null){
				cart.setMember_id(member.getId());
			}
			
			this.cartserviceimpl.addCart(cart);
			return "加入成功！";
		} catch (Exception e) {
			// TODO: handle exception
			return "网络出现问题";
		}
	}
}
