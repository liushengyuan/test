package com.springdemo.service;

import java.util.List;

public interface SeachService {
	/**
	 * 获得搜索的活动的列表
	 * @param cla
	 * @param child_cla
	 * @param three_cla
	 * @param keyword
	 * @return
	 */
	public List getSeachGoodsList(Integer cla,Integer child_cla,Integer three_cla,String keyword);
}
