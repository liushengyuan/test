package com.springdemo.dao;

import com.springdemo.po.Page;

public interface PageDao {
	/**
	 * 后台显示商品列表
	 * @return
	 */
	public Page showAlbum(int pageNo,int pageSize);
}
