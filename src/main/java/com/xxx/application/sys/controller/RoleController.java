package com.xxx.application.sys.controller;


import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xxx.application.sys.entity.Menu;
import com.xxx.application.sys.entity.Role;
import com.xxx.application.sys.entity.RoleMenu;
import com.xxx.application.sys.entity.UserRole;
import com.xxx.application.sys.service.IMenuService;
import com.xxx.application.sys.service.IRoleMenuService;
import com.xxx.application.sys.service.IRoleService;
import com.xxx.application.sys.service.IUserRoleService;
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
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private IRoleService roleService;
	@Autowired
	private IUserRoleService userRoleService;
	@Autowired
	private IRoleMenuService roleMenuService;
	@Autowired
	private IMenuService menuService;
	
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
	/**
	 * 通过uId查询其对应的权限
	 * @param uId
	 * @return
	 */
	@RequestMapping("/select/{uId}")
	public R selectRole(@PathVariable String uId){
		Set<String> roles = new HashSet<>();
		QueryWrapper<UserRole> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("userId", uId);
		
		List<UserRole> list = userRoleService.list(queryWrapper);
		for (UserRole userRole : list) {
			roles.add(userRole.getRoleId());
		}
		System.out.println(roles);
		QueryWrapper<RoleMenu> queryWrapper1 = new QueryWrapper<>();
		queryWrapper1.in("roleId", roles);
		List<RoleMenu> roleMenus = roleMenuService.list(queryWrapper1);
		Set<String> menus = new HashSet<>();
		for (RoleMenu roleMenu : roleMenus) {
			menus.add(roleMenu.getMenuId());
		}
		System.out.println(menus);
		QueryWrapper<Menu> menuQueryWrapper = new QueryWrapper<>();
		menuQueryWrapper.in("id", menus);
		List<Menu> list2 = menuService.list(menuQueryWrapper);
		Set<String> menuUrl = new HashSet<>();
		for (Menu menu : list2) {
			logger.info(menu.getUrl());
			menuUrl.add(menu.getUrl());
			
		}
		System.out.println(menuUrl);
		Map<String,Object> map = new HashMap<>();
		map.put("data", menuUrl);
		if (menuUrl != null) {
			
			return R.ok(map);
		}
		
		return R.error("查询失败");
	}

}
