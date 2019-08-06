package com.xxx.application.sys.controller;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.xxx.application.sys.entity.Role;
import com.xxx.application.sys.service.IRoleMenuService;
import com.xxx.application.sys.service.IRoleService;
import com.xxx.application.util.R;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author zyk
 * @since 2019-08-06
 */
@RestController
@RequestMapping("/sys/role")
public class RoleController {
	@Autowired
	private IRoleService roleService;
	@RequestMapping("/add")
	public R addRole(){
		Role role = new Role();
		role.setRoleName("管理员");
		role.setRoleDesc("管理员");
		role.setRoleState(1);
		System.out.println(role);
		try {
			boolean b = roleService.save(role);
			System.out.println(b);
			if (b) {
				return R.ok();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return R.error("添加失败");
	}

}
