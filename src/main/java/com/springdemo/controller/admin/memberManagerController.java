package com.springdemo.controller.admin;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.springdemo.dao.impl.PageResult;
import com.springdemo.po.Member;
import com.springdemo.service.MemberService;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.MethodAccessor_Double;

@Controller
@RequestMapping("/admin")
public class memberManagerController {
	
	//@Autowired 
    public JdbcTemplate jdbcTemplate;
	@Autowired
	private MemberService memberService;
	
	private static final int PAGE_LIMIT=3;
	
//	@RequestMapping("addMembers")
//	public String addMembers(Model model){
//		return "admin/member/add_members";
//	}
//	
//	@RequestMapping("/memberList")
//	public String memberList(Model model){
//		return "admin/member/member_list";
//	}
	@RequestMapping(value = "/getMemberList",produces = "application/json; charset=utf-8")
    public ModelAndView teacherFind(String page,String numPerPage){
		
    	ModelAndView mv = new ModelAndView();
        Integer currPage = 1;
        Integer numPerPageInit = 10;
        if(page!=null && !page.equals("")){
            currPage = new Integer(page);
        }
        if(numPerPage!=null && !numPerPage.equals("")){
        	numPerPageInit = new Integer(numPerPage);
        }
        Member member=new Member();
        
        PageResult<Member> pageResult = memberService.queryPageBusiness(currPage,
        		numPerPageInit,member );
        int[] result = {};
        int totalPages = pageResult.getTotalPages();
        if(pageResult.getTotalPages() > 0){
        	result = new int[totalPages];
        	for(int i = 0; i<totalPages;i++){
        		result[i] = i;
        	}
        	System.out.println(result);
        }
        System.out.println(pageResult.getResultList());
        System.out.println(pageResult.getStartIndex());
        System.out.println(pageResult.getLastIndex());
        //封装要显示到视图的数据6
        mv.addObject("pageResult",result);//页数信息
        mv.addObject("memberInfoPage",pageResult);//页数信息
        mv.addObject("memberInfos",pageResult.getResultList());//返回的具体数据值
    	//视图名
    	mv.setViewName("admin/member/member_list");
    	     
    	return mv;
    }
	
	/**
	 * @后台会员列表
	 */
//	@RequestMapping("/getMemberList")
//	public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest httpServletRequest,
//            javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
//		ModelAndView mv = new ModelAndView();
//		try {
//			List<Member> list = memberService.getMemberList();
//			//Collections.reverse(list);
//			//Collections.sort(list, Collections.reverseOrder());
//			//list.
//			//封装要显示到视图的数据6
//	    	mv.addObject("memberInfos",list);
//	    	//视图名
//	    	mv.setViewName("admin/member/member_list");
//	    	System.out.println("currentTimeMillis: "+System.currentTimeMillis());
//	    	return mv;
//		} catch (Exception e) {
//			// TODO: handle exce6ption6
//		}
//		
//		return null;
//    	
//	}
}