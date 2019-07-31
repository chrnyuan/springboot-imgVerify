package com.xxx.application.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
	@ResponseBody
	@PostMapping("/user/register")
	public String imgVerify(HttpServletRequest request, String imgVerify){
		System.out.println("imgVerify"+imgVerify);
		if (imgVerify.isEmpty()) {
			return "验证码不能为空";
		}
		HttpSession session = request.getSession();
		String verifyCode = (String) session.getAttribute("RANDOMVALIDATECODEKEY");
		if (imgVerify.equals(verifyCode)) {
			return "验证码正确";
		}
		return "验证码错误";
	}
}
