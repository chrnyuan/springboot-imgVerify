package com.xxx.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

	
	@RequestMapping("/aa.html")
	public String page(){
		System.out.println("-------------------");
		return "cv";
	}
	
	@RequestMapping("/app/test")
	public String page1(){
		System.out.println("-------------------");
		return "app";
	}
	
	
}
