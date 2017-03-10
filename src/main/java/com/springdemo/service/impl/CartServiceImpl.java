package com.springdemo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdemo.dao.CartDao;
import com.springdemo.po.Cart;
import com.springdemo.service.CartService;
@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartDao cartdaoimpl;
	
	@Override
	public void delCartGoods(Integer goods_id, Integer member_id) {
		// TODO Auto-generated method stub
		this.cartdaoimpl.delCartGoods(goods_id, member_id);
	}

	@Override
	public void delAllCartGoods(Integer goods_id) {
		// TODO Auto-generated method stub
		this.cartdaoimpl.delAllCartGoods(goods_id);
	}

	@Override
	public List getCartGoods(Integer member_id) {
		// TODO Auto-generated method stub
		return this.cartdaoimpl.getCartGoods(member_id);
	}

	@Override
	public void addCartGood(Integer member_id, Integer goods_id, Integer num) {
		// TODO Auto-generated method stub
		this.cartdaoimpl.addCartGood(member_id, goods_id, num);
	}

	@Override
	public void dowmCartGood(Integer member_id, Integer goods_id, Integer num) {
		// TODO Auto-generated method stub
		this.cartdaoimpl.dowmCartGood(member_id, goods_id, num);
	}

	@Override
	public void addCart(Cart cart) {
		// TODO Auto-generated method stub
		this.cartdaoimpl.addCart(cart);
	}

}
