package com.xxx.application.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xxx.test.TestDemo;

@RestController
public class HelloController{

	@RequestMapping("/")
	public String go(){
		return "this is a springboot project";
	}
	
	@RequestMapping("/ajax/demo_post2.asp")
	public String sayHello(){
		return "this is a springboot project";
	}
	
	@GetMapping("/ajax/demo_get.asp")
	public String ajax(){
		
		return "get ajax ";
	}
	
	@GetMapping("/AJAX3")
	public List ajax3(){
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("2");
		list.add("3");
		return list;
	}
}
