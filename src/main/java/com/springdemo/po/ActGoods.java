package com.springdemo.po;

public class ActGoods {
	//活动商品关联表
	private int id;
	private int act_id;
	private int goods_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAct_id() {
		return act_id;
	}
	public void setAct_id(int act_id) {
		this.act_id = act_id;
	}
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	
}
