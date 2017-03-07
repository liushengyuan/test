package com.springdemo.po;


import java.util.ArrayList;

public class Page {
	private ArrayList<Object> data;//数据
	private int totalRows;
	private int pageSize;
	private int totalPage;
	private int currentPage;
	public ArrayList<Object> getData() {
		return data;
	}
	public void setData(ArrayList<Object> data) {
		this.data = data;
	}
	public int getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPage() {
		if(this.totalRows%this.pageSize==0){
			return this.totalRows/this.pageSize;
		}else{
			return this.totalRows/this.pageSize+1;
		}
		
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public Page() {
		this.data=new ArrayList<Object>();
	}
	
}
