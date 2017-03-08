package com.springdemo.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springdemo.po.Page;
import com.springdemo.service.MessageService;

@Controller
@RequestMapping("/admin")
public class MessageController {
	
	@Autowired
	private MessageService messageserviceimpl;
	
	@RequestMapping("/getMessageList")
	public ModelAndView getMessageList(@RequestParam("page") int page,@RequestParam("pageSize")int pageSize){
		ModelAndView mv = new ModelAndView();
		Page pageList =this.messageserviceimpl.getMessageList(page, pageSize);
		mv.addObject("pageList",pageList);
		mv.setViewName("admin/message/message_list");
		return mv;
	}
}
