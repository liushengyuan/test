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
	/**
	 * @跳转MemberList
	 * @param page
	 * @param numPerPage
	 * @return
	 */
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
	 * @冻结与解冻账号
	 * @param id
	 * @param ifFrozenAccount
	 * @return
	 */
	@RequestMapping(value="/updateMemberAccountStatus",produces = "application/json; charset=utf-8")
	@ResponseBody
	public boolean updateMemberAccountStatus(int id,int ifFrozenAccount){
		ModelAndView mv = new ModelAndView();
		
		Member member = new Member();
		
		boolean status = this.memberService.updateAccountStatus(id, ifFrozenAccount);
		if(status){
			
			return true;
		}
		return false;
	}
}