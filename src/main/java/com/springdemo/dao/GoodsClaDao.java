package com.springdemo.dao;

import java.util.List;

public interface GoodsClaDao {
	/**
	 * 根据商品分类获得商品列表
	 * @param cla
	 * @param child_cla
	 * @param three_cla
	 * @return
	 */
	public List getGoodsCla(Integer cla,Integer child_cla,Integer three_cla,String keyword);
}
