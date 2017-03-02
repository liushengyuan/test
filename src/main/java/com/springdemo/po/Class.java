package com.springdemo.po;

public class Class {
	private int id;
	private int goods_id;//商品id
	private int cla;//分类  0男装  1女装 2 儿童
	private int child_cla;//子分类  0上衣  1 裤子  2 鞋子
	private int three_cla;//0棉衣  1 针织/毛衣   2 风衣   3 大衣    4   衬衫   5 卫衣 6小西装  7  运动衫   8 小背心/吊带   9 T恤
	//10牛仔裤   11 休闲裤   12 运动裤      13打底裤  14 背带裤  15  靴裤
	//16皮鞋，17凉鞋，18布鞋，19人造革鞋，20饰品鞋
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public int getCla() {
		return cla;
	}
	public void setCla(int cla) {
		this.cla = cla;
	}
	public int getChild_cla() {
		return child_cla;
	}
	public void setChild_cla(int child_cla) {
		this.child_cla = child_cla;
	}
	public int getThree_cla() {
		return three_cla;
	}
	public void setThree_cla(int three_cla) {
		this.three_cla = three_cla;
	}
	
}
