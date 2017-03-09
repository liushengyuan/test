package com.springdemo.dao;

import com.springdemo.po.MemberMessage;

public interface MessageDao {
	/**
	 * 删除消息
	 * @param id  消息id
	 */
	public void removeMessage(int id);
	/**
	 * 添加消息
	 * @param message
	 */
	public void addMessage(MemberMessage message);
}
