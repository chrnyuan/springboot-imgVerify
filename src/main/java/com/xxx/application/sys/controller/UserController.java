package com.xxx.application.sys.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xxx.application.sys.entity.User;
import com.xxx.application.sys.mapper.UserMapper;
import com.xxx.application.sys.service.IUserService;
import com.xxx.application.util.R;

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
	@Autowired private UserMapper userMapper;
	
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
	
	@RequestMapping("selectAll")
	public R getAllUser(){
		List<User> users = userMapper.selectList(null);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("users", users);
		return R.ok(map);
	}
	
	/**
	 * 注册
	 * @param request
	 * @param imgVerify
	 * @return
	 */
	@ResponseBody
	@PostMapping("/register")
	public String imgVerify(@RequestBody JSONObject jsonObject,HttpServletRequest request){
		/*Enumeration<String> parameterNames = request.getParameterNames();
		String username = request.getParameter("username");
		System.out.println("\\"+username);
		String imgVerify = request.getParameter("imgVerify");*/
		//判断图片验证码是否为空
		String imgVerify = jsonObject.getString("imgVerify");
		String username = jsonObject.getString("username");
		String password = jsonObject.getString("password");
		
		//判读字符串的长度
		/*String trim = imgVerify.trim();
		if ( trim.length()==0 ) {
			return "验证码不能为空";
		}*/
		if (imgVerify.isEmpty()) {
			return "验证码不能为空";	
		}
		Cookie[] cookies = request.getCookies();
		
		HttpSession session = request.getSession();
		String verifyCode = (String) session.getAttribute("RANDOMVALIDATECODEKEY");
		if (!imgVerify.equals(verifyCode)) {
//			int b = 3/0;
			return "0";
		}
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("password", password);
		queryWrapper.eq("userName", username);
		try {
			User user = userMapper.selectOne(queryWrapper);
			if (user == null) {
				return "-1";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "1";
	}
	/**
	 * 查询判断username是否存在
	 * @param username
	 * @return
	 */
	@PostMapping("/selectUsername")
	public R selectUsername(String username){
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("userName", username);
		User user = userMapper.selectOne(queryWrapper);
		if (user != null) {
			return R.ok();
		}
		return R.error(1, "此账号不存在");
	}
	
	@PostMapping("/login")
	public R login(String username,String password,HttpServletRequest request,HttpServletResponse response){
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("userName", username);
		queryWrapper.eq("password", password);
		User user = userMapper.selectOne(queryWrapper);
		System.out.println("user"+user);
		if (user != null) {
			System.out.println("---------------------");
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			return R.ok();
		}
		return R.error(1, "密码错误");
	}
}
