package com.xxx.application.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Null;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * 拦截器
 * @author ZYK
 * 2019年8月16日 下午1:52:49
 * Desc:
 * HandlerInterceptor是springMvc项目中的拦截器
 */
public class MyInterceptor implements HandlerInterceptor{

		@Override
		public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
			//返回为true 才会向下执行
			System.out.println("MyInterceptor preHandle");
			String requestURI = request.getRequestURI(); //获取到请求路径
			System.out.println("requestURL"+requestURI);
			String serverName = request.getServerName();
			System.out.println(serverName);
			HttpSession session = request.getSession();
			if (session.getAttribute("user") ==null) {
				return false;
			}
			return true;
		}
		
		
		@Override
		public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
				ModelAndView modelAndView) throws Exception {
			// TODO Auto-generated method stub
			System.out.println("MyInterceptor postHandle");
		}

		@Override
		public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
			System.out.println("MyInterceptor afterComletion");
		}
	
}
