package com.springdemo.service;

import com.springdemo.po.Goods;
import com.springdemo.po.Goodscla;

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
}
