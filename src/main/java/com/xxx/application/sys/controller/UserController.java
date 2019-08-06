package com.xxx.application.sys.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.xxx.application.sys.entity.User;
import com.xxx.application.sys.mapper.UserMapper;
import com.xxx.application.sys.service.IUserService;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author zyk
 * @since 2019-08-06
 */
@RestController
@RequestMapping("/sys/user")
public class UserController {
	
	@Autowired
	private IUserService userService;
	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping("/add")
	public String addUser(){
		User user = new User();
		user.setUserName("ss");
		user.setPassword("1111111");
		user.setUserState(1);
		System.out.println(user);
		boolean b = userService.save(user);
		if (b) {
			return "success";
		}
		return "fail";
	}

}
