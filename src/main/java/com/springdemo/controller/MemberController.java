package com.springdemo.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.springdemo.po.Member;
import com.springdemo.service.MemberService;

@Controller
@RequestMapping("/admin")
public class MemberController {
	//@Autowired 
    public JdbcTemplate jdbcTemplate;
	@Autowired
	private MemberService memberService;
	
	/**
	 * @前端会员登录
	 */
	@RequestMapping(value = "memberLogin" , produces = "application/json; charset=utf-8")
	@ResponseBody
	public String memberLogin(@RequestParam("memberName") String memberName,
			@RequestParam("password") String password){
		Member member = new Member();
		Gson gson = new Gson();
		Map<String,Object> map = new HashMap<String,Object>();
		//检查用户名是否已经被注册
		try {
			List<Member> list = this.memberService.memberLogin(memberName,password);
			if(list.size()>0){
				int ifFrozenAccount = list.get(0).getIfFrozenAccount();
				if(ifFrozenAccount == 1){
					map.put("result", "0");
					map.put("message", "您的账号已被冻结，请与网站管理员联系");
					String jsonError = gson.toJson(map);
					return jsonError;
				}
				map.put("result", "1");
				map.put("message", "登录成功");
				String jsonError = gson.toJson(map);
				return jsonError;
			}
		} catch (Exception e) {
			// TODO: handle exception
			map.put("result", "0");
			map.put("message", "出现错误了，小的正在努力调整");
			String jsonError = gson.toJson(map);
			return jsonError;
		}
		map.put("result", "0");
		map.put("message", "用户名或密码错误");
		String jsonError = gson.toJson(map);
		return jsonError;
	}
	/**
	 * @前端会员注册
	 */
	@RequestMapping(value = "/addMembers",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String addMembers(@RequestParam("memberName") String memberName,
							@RequestParam("password") String password){
		Member member = new Member();
		Gson gson = new Gson();
		Map<String,Object> map = new HashMap<String,Object>();
        //添加会员名、密码、账号状态 （0:初始状态,1：账号被冻结）
		member.setMemberName(memberName);
		member.setPassword(password);
		member.setIfFrozenAccount(0);
		//添加创建日期
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		long now = System.currentTimeMillis();
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(now);
		System.out.println(now + " = " + formatter.format(calendar.getTime()));
		String createDate = formatter.format(calendar.getTime());
		member.setCreateDate(createDate);
		//检查用户名是否已经被注册
		List list = this.memberService.getMemberByName(member.getMemberName());
		if(list.size()>0){
			String returnInfo = "用户名( "+member.getMemberName()+" )已经存在";
			map.put("result", "0");
			map.put("message", returnInfo);
			String jsonError = gson.toJson(map);
			return jsonError;
		}
		//获取数据库状态
		boolean status = this.memberService.addMembers(member);
		if(status){
			map.put("result", "1");
			map.put("message", "注册成功");
			String json = gson.toJson(map);
			return json;
		}
		map.put("result", "0");
		map.put("message", "注册失败");
		String jsonError = gson.toJson(map);
		return jsonError;
	}
}
