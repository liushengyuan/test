package com.springdemo.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springdemo.dao.CartDao;
import com.springdemo.po.Cart;
@SuppressWarnings("deprecation")
@Repository 
public class CartDaoImpl implements CartDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private SimpleJdbcTemplate simpleJdbcTemplate;
	
	@Override
	public void delCartGoods(Integer goods_id, Integer member_id) {
		// TODO Auto-generated method stub
		String sql="delete from cart where goods_id=? and member_id =?";
		this.simpleJdbcTemplate.update(sql, goods_id,member_id);
	}

	@Override
	public void delAllCartGoods(Integer goods_id) {
		// TODO Auto-generated method stub
		String sql ="delete from cart where member_id =?";
		this.simpleJdbcTemplate.update(sql, goods_id);
	}

	@Override
	public List getCartGoods(Integer member_id) {
		// TODO Auto-generated method stub
		String sql ="select * from cart where member_id =?";
		List goodsList = this.simpleJdbcTemplate.queryForList(sql, member_id);
		return goodsList;
	}

	@Override
	public void addCartGood(Integer member_id, Integer goods_id,Integer num) {
		// TODO Auto-generated method stub
		String sql ="UPDATE cart SET num = ? WHERE member_id = ? and goods_id= ? ";
		this.simpleJdbcTemplate.update(sql, num,member_id,goods_id);
	}

	@Override
	public void dowmCartGood(Integer member_id, Integer goods_id, Integer num) {
		// TODO Auto-generated method stub
		String sql ="UPDATE cart SET num = ? WHERE member_id = ? and goods_id= ? ";
		this.simpleJdbcTemplate.update(sql, num,member_id,goods_id);
	}

	@Override
	public void addCart(Cart cart) {
		// TODO Auto-generated method stub
		String sql ="insert into cart(goods_id,goods_name,goods_image1,goods_price,is_select) values(?,?,?,?,?)";
		this.simpleJdbcTemplate.update(sql, cart.getGoods_id(),cart.getGoods_name(),cart.getGoods_image1(),1);
	}

}
