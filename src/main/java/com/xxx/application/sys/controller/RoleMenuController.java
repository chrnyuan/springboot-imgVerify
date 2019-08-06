package com.xxx.application.sys.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.xxx.application.sys.entity.RoleMenu;
import com.xxx.application.sys.service.IRoleMenuService;
import com.xxx.application.sys.service.impl.RoleMenuServiceImpl;
import com.xxx.application.util.R;

/**
 * <p>
 * 角色菜单关联表 前端控制器
 * </p>
 *
 * @author zyk
 * @since 2019-08-06
 */
@RestController
@RequestMapping("/sys/role-menu")
public class RoleMenuController {
	@Autowired
	private IRoleMenuService roleMenuService;
	@RequestMapping("addRoleMenu")
	public R add(){
		RoleMenu roleMenu = new RoleMenu();
		
		roleMenu.setRoleId("9c8002529751490a50aefd45172ecfdd");
		roleMenu.setMenuId("0818e1c76bbd44eba3a698547ec4e637");
		boolean b = roleMenuService.save(roleMenu);
		if (b) {
			return R.ok();
		}
		return R.error("角色菜单添加失败");
	}
	

}
