package com.springdemo.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

/**
 * 
 * @author AHJ
 *
 * @param <T>
 */
public class PageResult<T> implements Serializable{
	//默认每页10条记录
	public static final int NUMBERS_PER_PAGE = 10;
	//每页显示的记录数
	private int numPerPage;
	//记录总数
	private int totalRows;
	//总页数
	private int totalPages;
	//当前页码
	private int currentPage;
	//起始行数
	private int startIndex;
	//结束行数
	private int lastIndex;
	//结果集存放list
	private List<T> resultList;
	//jdbcTemplate jTemplate
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcTemplate simpleJdbcTemplate;
	
	/**
	 * 每页显示10条的构造函数,使用该构造函数必须先给Pagination设置currentPage,jTemplate初值
	 * @param sql
	 */
	public PageResult(String sql){
		if(simpleJdbcTemplate == null){
			//IllegalArgumentException此异常表明向方法传递了一个不合法或不正确的参数。你看看传值的方法是否参数不正确
			throw new IllegalArgumentException("com.itbegin.dao.base.PageResult.jTemplate is null,please initial it first. ");
		}else if(sql.equals("")){
			throw new IllegalArgumentException("com.itbegin.dao.base.PageResult.sql is empty,please initial it first. ");
		}
		new PageResult<T>(sql,currentPage,NUMBERS_PER_PAGE,simpleJdbcTemplate);
	}
	
	/**分页构造函数
	 * @param sql 根据传入的sql语句得到一些基本分页信息
	 * @param currentPage 当前页
	 * @param NUMBER_PER_PAGE 每页记录数
	 * @param jTemplate JdbcTemplate实例
	 */
	public PageResult(String sql, int currentPage ,int numPerPage,SimpleJdbcTemplate simpleJdbcTemplate){
		 if(simpleJdbcTemplate == null){
            throw new IllegalArgumentException("com.deity.ranking.util.Pagination.jTemplate is null,please initial it first. ");
        }else if(sql == null || sql.equals("")){
            throw new IllegalArgumentException("com.deity.ranking.util.Pagination.sql is empty,please initial it first. ");
        }
		 
		//设置每页显示记录数
        setNumPerPage(numPerPage);
        //设置要显示的页数
        setCurrentPage(currentPage);
        //计算总记录数
        StringBuffer totalSQL = new StringBuffer(" SELECT count(*) FROM ( ");
        totalSQL.append(sql);
        totalSQL.append(" ) totalTable ");
        //给JdbcTemplate赋值
        this.simpleJdbcTemplate = simpleJdbcTemplate;
        //总记录数
        setTotalRows(getSimpleJdbcTemplate().queryForObject(totalSQL.toString(),Integer.class));
        //计算总页数
        setTotalPages();
        //计算起始行数
        setStartIndex();
        //计算结束行数
        setLastIndex();

        //装入结果集
        setResultList(getSimpleJdbcTemplate().queryForList(getMySQLPageSQL(sql,startIndex,numPerPage)));
	}
	
	/**
    * 构造MySQL数据分页SQL
    * @param queryString
    * @param startIndex
    * @param pageSize
    * @return
    */
	public String getMySQLPageSQL(String queryString, Integer startIndex, Integer pageSize){
       String result = "";
	   if (null != startIndex && null != pageSize){
	       result = queryString + " limit " + startIndex + "," + pageSize;
	   } else if (null != startIndex && null == pageSize){
	       result = queryString + " limit " + startIndex;
       } else{
           result = queryString;
       }
       return result;
    }
	
	public int getNumPerPage() {
		return numPerPage;
	}
	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}
	public int getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}
	public int getTotalPages() {
		return totalPages;
	}
	//计算总页数
	public void setTotalPages() {
		if(totalRows % numPerPage == 0){
            this.totalPages = totalRows / numPerPage;
        }else{
            this.totalPages = (totalRows / numPerPage) + 1;
        }
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex() {
		this.startIndex = (currentPage - 1) * numPerPage;
	}
	public int getLastIndex() {
		return lastIndex;
	}
	//计算结束的索引
	public void setLastIndex() {
		//System.out.println("totalRows="+totalRows);///////////
        //System.out.println("numPerPage="+numPerPage);///////////
        if( totalRows < numPerPage){
            this.lastIndex = totalRows;
        }else if((totalRows % numPerPage == 0) || (totalRows % numPerPage != 0 && currentPage < totalPages)){
            this.lastIndex = currentPage * numPerPage;
        }else if(totalRows % numPerPage != 0 && currentPage == totalPages){//最后一页
            this.lastIndex = totalRows ;
        }
	}
	public List<T> getResultList() {
		return resultList;
	}
	public void setResultList(List resultList) {
		this.resultList = resultList;
	}
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public SimpleJdbcTemplate getSimpleJdbcTemplate() {
		return simpleJdbcTemplate;
	}

	public void setSimpleJdbcTemplate(SimpleJdbcTemplate simpleJdbcTemplate) {
		this.simpleJdbcTemplate = simpleJdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public static int getNumbersPerPage() {
		return NUMBERS_PER_PAGE;
	}
	
	@Override
	public String toString(){
		return "totalRows:"+totalRows+" totalPages:"+totalPages+" currentPage:"+currentPage+resultList;
	}
	
}
