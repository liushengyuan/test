package com.springdemo.service;

import java.util.List;

import com.springdemo.po.Goods;
import com.springdemo.po.Goodscla;
import com.springdemo.po.Page;

public interface GoodsService {
	/**
	 * 后台添加商品
	 * @param goods
	 * @return
	 */
	public void addGoods(Goods goods);
	/**
	 * 查询最后添加商品的id
	 */
	public int lastGoodsid();
	/**
	 * 添加商品分类
	 * @param Goodscla
	 */
	public void addGoodscla(Goodscla Goodscla);
	/**
	 * 获得商品列表
	 * @return
	 */
	public Page getGoodsPage(int page,int pageSize);
	/**
	 * 修改商品状态
	 * @param goods_id
	 * @param style
	 */
	public void changeGoods(int goods_id,int style);
	/**
	 * 后台获得订单列表
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public Page getOrderPage(int page,int pageSize);
	/**
	 * 获取商品详情
	 * @param goods_id
	 * @return
	 */
	public List<Goods> getGoodsInfo(int goods_id);
}
