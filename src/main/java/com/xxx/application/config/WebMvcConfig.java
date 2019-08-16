package com.xxx.application.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.xxx.application.interceptor.MyInterceptor;
/**
 * springmvc 配置
 * @author ZYK
 * 2019年8月16日 下午1:25:09
 * Desc:
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport{
	
	/**
	 *把Interceptor注册到mvc
	 *重写添加拦截器方法并添加配置拦截器
	 */
	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		System.out.println("准备注册拦截器");
		// TODO Auto-generated method stub
		registry.addInterceptor(new MyInterceptor()).addPathPatterns("/app/**")
				.excludePathPatterns("static/**");
	}
	/**
	 * 配置静态资源路径
	 */
	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
		WebMvcConfig.super.addResourceHandlers(registry);
	}
	
	
}
