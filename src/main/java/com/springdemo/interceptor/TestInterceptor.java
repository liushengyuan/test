package com.springdemo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
/**
 * 
 * @author jfw
 * Spring AOP 拦截器
 */
public class TestInterceptor extends HandlerInterceptorAdapter {
	 	@Override
	    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
	            // 请求处理完成之后
	            System.out.println("请求处理完成啦！");
	            super.afterCompletion(request, response, handler, ex);
	    }

	    @Override
	    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
	            // 处理器执行完毕之后
	            System.out.println("处理器执行完毕啦！");
	            super.postHandle(request, response, handler, modelAndView);
	    }

	    @Override
	    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	            // 处理器实际执行之前
	            System.out.println("处理器执行之前！");
	            Object user = request.getSession().getAttribute("adminUser");
                if (user == null) {
	                 System.out.println("尚未登录，调到登录页面");
	                 response.sendRedirect("../user/isLogin");
	                 return false;
                }
	            return super.preHandle(request, response, handler);
	    }
}
