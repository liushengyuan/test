package com.springdemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.springdemo.po.Admin;
import com.springdemo.po.Goods;
import com.springdemo.po.Goodscla;

@SuppressWarnings("deprecation")
@Repository
public class GoodsDaoImpl implements GoodsDao{
	
	@Autowired 
	private JdbcTemplate jdbcTemplate; 
	
	@Autowired
	private SimpleJdbcTemplate simpleJdbcTemplate;
	@Override
	public void addGoods(Goods goods) {
		// TODO Auto-generated method stub
		String sql="insert into goods (goods_name,price,info,is_check,image1,image2,image3) values (?,?,?,?,?,?,?);";
		this.simpleJdbcTemplate.update(sql,goods.getGoods_name(),goods.getPrice(),goods.getInfo(),goods.getIs_check(),goods.getImage1(),goods.getImage2(),goods.getImage3());
	}
	@Override
	public int getLastGoodsid() {
		// TODO Auto-generated method stub
		String sql="select id from goods order by id desc limit 1";
		int goods_id =this.simpleJdbcTemplate.queryForInt(sql);
		return goods_id;
	}
	@Override
	public void addGoodscla(Goodscla goodscla) {
		// TODO Auto-generated method stub
		String sql="insert into goodscla (goods_id,cla,child_cla,three_cla) values (?,?,?,?);";
		this.simpleJdbcTemplate.update(sql,goodscla.getGoods_id(),goodscla.getCla(),goodscla.getChild_cla(),goodscla.getThree_cla());
	}
	@Override
	public void changeGoods(int goods_id, int style) {
		// TODO Auto-generated method stub
		String sql="update goods set is_check=0 where id = ?";
		if(style==1){
			 sql="update goods set is_check=1 where id = ?";
		}
		this.simpleJdbcTemplate.update(sql,goods_id);
	}
	@Override
	public List<Goods>  getGoodsInfo(int goods_id) {
		// TODO Auto-generated method stub
		String sql="select * from goods where id= ?";
		
		List<Goods> list = this.simpleJdbcTemplate.query(sql,
				ParameterizedBeanPropertyRowMapper.newInstance(Goods.class), goods_id);
		return list;
	}

}
