package com.springdemo.service;

import java.util.List;

public interface ActService {
	/**
	 * 删除活动商品
	 * @param act_id
	 * @param goods_id
	 */
	public void delActGoods(int act_id,int goods_id);
	/**
	 * 添加活动商品
	 * @param act_id
	 * @param goods_id
	 */
	public void addActGoods(int act_id,int goods_id);
	/**
	 * 获得活动商品列表
	 * @return
	 */
	public List getActGoods();
}
