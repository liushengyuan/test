package com.springdemo.dao.impl;


import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springdemo.dao.PageDao;
import com.springdemo.po.Page;

@SuppressWarnings("deprecation")
@Repository
public class PageDaoImpl implements PageDao {
	@Autowired 
	private JdbcTemplate jdbcTemplate; 
	
	@Autowired
	private SimpleJdbcTemplate simpleJdbcTemplate;
	//分页显示商品列表
	public Page showAlbum(int pageNo,int pageSize) {
		// TODO Auto-generated method stub
		Page page=new Page();
		int totalRows=0;
		String sqlCount="select  count(id) from goods";
		totalRows=  this.simpleJdbcTemplate.queryForInt(sqlCount);
		page.setTotalRows(totalRows);
		int c = totalRows%pageSize==0?totalRows/pageSize:totalRows/pageSize+1;
		page.setTotalPage(c);
		page.setPageSize(pageSize);
		int currentPage=pageNo;
		page.setCurrentPage(currentPage);
		String sql="SELECT*from goods  limit "+(currentPage-1)*pageSize+","+pageSize+"";
		List<Map<String, Object>> listGoods = this.simpleJdbcTemplate.queryForList(sql);
		for (Map<String, Object> map : listGoods) {
			page.getData().add(map);
		}
		return page;
	}
	@Override
	public Page showMessage(int pageNo, int pageSize) {
		Page page=new Page();
		int totalRows=0;
		String sqlCount="select  count(id) from member_message";
		totalRows=  this.simpleJdbcTemplate.queryForInt(sqlCount);
		page.setTotalRows(totalRows);
		int c = totalRows%pageSize==0?totalRows/pageSize:totalRows/pageSize+1;
		page.setTotalPage(c);
		page.setPageSize(pageSize);
		int currentPage=pageNo;
		page.setCurrentPage(currentPage);
		String sql="SELECT*from member_message  limit "+(currentPage-1)*pageSize+","+pageSize+"";
		List<Map<String, Object>> listGoods = this.simpleJdbcTemplate.queryForList(sql);
		for (Map<String, Object> map : listGoods) {
			page.getData().add(map);
		}
		return page;
	}
	@Override
	public Page getActGoodsList(int pageNo, int pageSize,int act_id) {
		Page page=new Page();
		int totalRows=0;
		String sqlCount="select  count(id) from act_goods where act_id =?";
		totalRows=  this.simpleJdbcTemplate.queryForInt(sqlCount,act_id);
		page.setTotalRows(totalRows);
		int c = totalRows%pageSize==0?totalRows/pageSize:totalRows/pageSize+1;
		page.setTotalPage(c);
		page.setPageSize(pageSize);
		int currentPage=pageNo;
		page.setCurrentPage(currentPage);
		String sql="SELECT*from act_goods where act_id = ?  limit "+(currentPage-1)*pageSize+","+pageSize+"";
		List<Map<String, Object>> listGoods = this.simpleJdbcTemplate.queryForList(sql,act_id);
		for (Map<String, Object> map : listGoods) {
			page.getData().add(map);
		}
		return page;
	}
	@Override
	public Page getNoActGoods(int pageNo, int pageSize,int act_id) {
		Page page=new Page();
		int totalRows=0;
		String sqlCount="select  count(id) from act_goods where act_id !=?";
		totalRows=  this.simpleJdbcTemplate.queryForInt(sqlCount,act_id);
		page.setTotalRows(totalRows);
		int c = totalRows%pageSize==0?totalRows/pageSize:totalRows/pageSize+1;
		page.setTotalPage(c);
		page.setPageSize(pageSize);
		int currentPage=pageNo;
		page.setCurrentPage(currentPage);
		String sql="SELECT*from act_goods where act_id != ?  limit "+(currentPage-1)*pageSize+","+pageSize+"";
		List<Map<String, Object>> listGoods = this.simpleJdbcTemplate.queryForList(sql,act_id);
		for (Map<String, Object> map : listGoods) {
			page.getData().add(map);
		}
		return page;
	}
	
}
