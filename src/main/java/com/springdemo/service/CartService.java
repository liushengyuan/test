package com.springdemo.service;

import java.util.List;

public interface CartService {
	/**
	 * 删除购物车商品
	 * @param goods_id
	 * @param member_id
	 */
	public void delCartGoods(Integer goods_id,Integer member_id);
	/**
	 * 删除购物车所有商品
	 * @param goods_id
	 */
	public void delAllCartGoods(Integer goods_id);
	/**
	 * 查看购物车商品
	 * @param member_id
	 * @return
	 */
	public List getCartGoods(Integer member_id);
	/**
	 * 添加购物车商品数量
	 * @param member_id
	 * @param goods_id
	 */
	public void addCartGood(Integer member_id,Integer goods_id,Integer num);
	/**
	 * 减少购物车数量
	 * @param member_id
	 * @param goods_id
	 * @param num
	 */
	public void dowmCartGood(Integer member_id,Integer goods_id,Integer num);
}
