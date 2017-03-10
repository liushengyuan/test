package com.springdemo.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springdemo.po.Cart;
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
	
	//查看购物车商品
	@RequestMapping(value="/getCartGoods",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String getCartGoods(){
		try {
			this.cartserviceimpl.getCartGoods(member_id);
			return "";
		} catch (Exception e) {
			// TODO: handle exception
			return "网络错误！";
		}
	}
	@RequestMapping(value="/addCart",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String addCart(){
		try {
			Cart cart = new Cart();
			this.cartserviceimpl.addCart(cart);
			return "加入成功！";
		} catch (Exception e) {
			// TODO: handle exception
			return "网络出现问题";
		}
	}
}
