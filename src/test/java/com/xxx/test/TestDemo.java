package com.xxx.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.xxx.application.sys.entity.User;
import com.xxx.application.sys.service.IUserService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDemo {
	@Autowired
	private IUserService userService;
	@Test
	public void add(){
		User user = new User();
		user.setUserName("ss");
		user.setPassword("1111111");
		user.setUserState(1);
		System.out.println(user);
		boolean b = userService.save(user);
		if (b) {
			System.out.println("成功");
			return;
		}
		System.out.println("失败");
	}
}
