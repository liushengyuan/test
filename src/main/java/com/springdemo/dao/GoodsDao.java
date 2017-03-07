package com.springdemo.dao;

import com.springdemo.po.Goods;
import com.springdemo.po.Goodscla;

public interface GoodsDao {
	/**
	 * 后台上传商品
	 * @param goods
	 * @return
	 */
	public void addGoods(Goods goods);
	/**
	 * 获取最后添加商品的id
	 * @return
	 */
	public int getLastGoodsid();
	/**
	 * 添加商品分类
	 * @param goodscla
	 */
	public void addGoodscla(Goodscla goodscla);
}
