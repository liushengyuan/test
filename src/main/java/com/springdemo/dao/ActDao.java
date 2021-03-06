package com.springdemo.dao;

import java.util.List;

public interface ActDao {
	/**
	 * 添加活动关联的商品
	 * @param act_id
	 * @param goods_id
	 */
	public void addActGoods(int act_id,int goods_id);
	/**
	 * 删除活动关联的商品
	 * @param act_id
	 * @param goods_id
	 */
	public void delActGoods(int act_id,int goods_id);
	/**
	 * 获取活动列表
	 * @return
	 */
	public List getActGoodsList();
}
