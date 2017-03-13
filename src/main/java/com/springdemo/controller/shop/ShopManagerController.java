package com.springdemo.controller.shop;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.springdemo.po.Goods;
import com.springdemo.po.Member;
import com.springdemo.po.MemberMessage;
import com.springdemo.po.Order;
import com.springdemo.service.ActService;
import com.springdemo.service.CartService;
import com.springdemo.service.GoodsService;
import com.springdemo.service.MemberService;
import com.springdemo.service.MessageService;
import com.springdemo.service.OrderService;
import com.springdemo.service.SeachService;

@Controller
public class ShopManagerController {
	@Autowired 
	private ActService actserviceimpl;
	@Autowired 
	private OrderService orderserviceimpl;
	@Autowired
	private GoodsService goodsserviceimpl;
	@Autowired
	private SeachService seachserviceimpl;
	@Autowired
	private MessageService messageserviceimpl;
	@Autowired
	private MemberService memberserviceimpl;
	@Autowired
	private CartService cartserviceimpl;
	//@Autowired 
    public JdbcTemplate jdbcTemplate;
	@Autowired
	private MemberService memberService;
		//获得活动列表
		@RequestMapping(value="/getActList",produces = "application/json; charset=utf-8")
		public ModelAndView getActList(){
			ModelAndView mv = new ModelAndView();
			try {
				List actGoodsList =this.actserviceimpl.getActGoods();
				mv.addObject("actGoodsList",actGoodsList);
				mv.setViewName("../../index");
		        return mv;
			} catch (Exception e) {
				// TODO: handle exception
				return mv;
			}
		}
		//添加订单
		@RequestMapping(value="/addOrder",produces = "application/json; charset=utf-8")
		public String addOrder(){
			try {
				Order order = new Order();
				this.orderserviceimpl.addOrder(order);
				return "下订单成功";
			} catch (Exception e) {
				// TODO: handle exception
				return "网络错误";
			}
		}
		//查看商品详情
		@RequestMapping(value="/getGoodsInfo",produces = "application/json; charset=utf-8")
		public ModelAndView getGoodsInfo(@RequestParam(value = "goods_id", required = false, defaultValue = "") Integer goods_id){
			ModelAndView mv = new ModelAndView();
			try {
			List<Goods>	list =this.goodsserviceimpl.getGoodsInfo(goods_id);
			if(list.get(0)!=null){
				if(list.get(0).getImage1()!=""){
					String url2 ="/springmvc"+list.get(0).getImage1().split("springmvc")[1];
					list.get(0).setImage1(url2);
				}
				if(list.get(0).getImage3()!=""){
					String url2 ="/springmvc"+list.get(0).getImage3().split("springmvc")[1];
					list.get(0).setImage2(url2);
				}
				if(list.get(0).getImage3()!=""){
					String url2 ="/springmvc"+list.get(0).getImage3().split("springmvc")[1];
					list.get(0).setImage3(url2);
				}
				mv.addObject("goodsinfo",list.get(0));
				
			}
				mv.setViewName("../../shop/single");
				return mv;
			} catch (Exception e) {
				// TODO: handle exception
				mv.setViewName("../../shop/single");
				return mv;
			}
		}
		//添加消息
		@RequestMapping(value="/addMessage",produces = "application/json; charset=utf-8")
		@ResponseBody
		public String addMessage(){
			try {
				HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
				String name =request.getParameter("name");
				String email =request.getParameter("email");
				String myphone =request.getParameter("phone");
				String messageInfo =request.getParameter("info");
				MemberMessage message =new MemberMessage();
				message.setMember_email(email);
				message.setMember_id(0);
				message.setMember_name(name);
				message.setMember_phone(myphone);
				message.setMessage(messageInfo);
				this.messageserviceimpl.addMessage(message);
				return "发送留言成功";
			} catch (Exception e) {
				// TODO: handle exception
				return "网络错误";
			}
		}
		//注册用户
		@RequestMapping(value="/addMember",produces = "application/json; charset=utf-8")
		@ResponseBody
		public String addMember(){
			try {
				HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
				String name =request.getParameter("memberName");
				String password =request.getParameter("password");
				String adddress =request.getParameter("adddress");
				Member member = new Member();
				long tiem= System.currentTimeMillis();
				String creattime =transferLongToDate("yyyy/dd/MM",tiem);
				member.setCreateDate(creattime);
				member.setAddress(adddress);
				member.setIfFrozenAccount(1);
				member.setMemberName(name);
				member.setMobile("");
				member.setPassword(password);
				this.memberserviceimpl.addMembers(member);
				Gson gson = new Gson();
				String json = gson.toJson("用户注册成功");
				return json;
			} catch (Exception e) {
				// TODO: handle exception
				return "网络错误";
			}
		}
		//时间转化
		 private String transferLongToDate(String dateFormat,Long millSec){
		     SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		     Date date= new Date(millSec);
		            return sdf.format(date);
		}
		//用户登陆
		 @RequestMapping(value="/login",produces = "application/json; charset=utf-8")
		 @ResponseBody
		 public String login(){
			try {
				HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
				String name =request.getParameter("memberName");
				String password =request.getParameter("password");
				List<Member> list =this.memberserviceimpl.memberLogin(name, password);
				request.getSession().setAttribute("member", list.get(0));
				Gson gson = new Gson();
				String json = gson.toJson("用户登陆成功");
				return json;
			} catch (Exception e) {
				// TODO: handle exception
				return "网络错误";
			}
		}
		 /**
			 * @前端会员登录
			 */
			@RequestMapping(value = "memberLogin" , produces = "application/json; charset=utf-8")
			@ResponseBody
			public String memberLogin(@RequestParam("memberName") String memberName,
					@RequestParam("password") String password){
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
						HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
						request.getSession().setAttribute("member", list.get(0));
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
				String address = "大学角落";
				String mobile = "18888888888";
				member.setMemberName(memberName);
				member.setPassword(password);
				member.setIfFrozenAccount(0);
				member.setAddress(address);
				member.setMobile(mobile);
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
		//查看购物车商品
		@RequestMapping(value="/getCartGoods",produces = "application/json; charset=utf-8")
		@ResponseBody
		public ModelAndView getCartGoods(){
			ModelAndView mv = new ModelAndView();
			
			try {
				
				HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
				Member member =(Member) request.getSession().getAttribute("member");
				if(member!=null){
					List list =(List) this.cartserviceimpl.getCartGoods(member.getId());
					mv.addObject("list",list);
				}
				mv.setViewName("../../shop/checkout");
				return mv;
			} catch (Exception e) {
				// TODO: handle exception
				mv.setViewName("../../shop/checkout");
				return mv;
			}
		}
}
