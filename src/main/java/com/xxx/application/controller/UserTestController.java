package com.xxx.application.controller;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.github.jarod.qqwry.IPZone;
import com.github.jarod.qqwry.QQWry;

//@Controller
public class UserTestController {
	@ResponseBody
	@PostMapping("/user/register")
	public String imgVerify(HttpServletRequest request, String imgVerify){
		
		//判断图片验证码是否为空
		System.out.println("imgVerify"+imgVerify);
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
		if (imgVerify.equals(verifyCode)) {
//			int b = 3/0;
			return "验证码正确";
		}
		return "验证码错误";
	}
	
	@PostMapping("/user/ip")
	@ResponseBody
	public String getAddress(@RequestBody JSONObject jsonObject) throws IOException{
		System.out.println(jsonObject.get("ip"));
//		 AddressUtils addressUtils = new AddressUtils();  
         // 测试ip 219.136.134.157 中国=华南=广东省=广州市=越秀区=电信  
		String ip= (String) jsonObject.get("ip"); 
		
		QQWry qqwry = new QQWry(); // load qqwry.dat from classpath

//		QQWry qqwry = new QQWry(Paths.get("path/to/qqwry.dat")); // load qqwry.dat from java.nio.file.Path
//
//		byte[] data = Files.readAllBytes(Paths.get("path/to/qqwry.dat"));
//		QQWry qqwry = new QQWry(data); // create QQWry with provided data

//		String myIP = "127.0.0.1";
		IPZone ipzone = qqwry.findIP(ip);
		System.out.printf("%s, %s", ipzone.getMainInfo(), ipzone.getSubInfo());
		// IANA, 保留地址用于本地回送
		
      return "ok";
	}
	
	
	
}
