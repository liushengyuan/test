package com.springdemo.dao;

import com.springdemo.po.Page;

public interface PageDao {
	/**
	 * 后台显示商品列表
	 * @return
	 */
	public Page showAlbum(int pageNo,int pageSize);
	/**
	 * 分页显示消息列表
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Page showMessage(int pageNo,int pageSize);
	/**
	 * 获得活动关联的商品
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Page getActGoodsList(int pageNo,int pageSize,int act_id);
	/**
	 * 获得活动没有关联的商品
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Page getNoActGoods(int pageNo,int pageSize,int act_id);
}
