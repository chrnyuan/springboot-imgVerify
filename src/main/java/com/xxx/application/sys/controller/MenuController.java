package com.xxx.application.sys.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xxx.application.sys.entity.Menu;
import com.xxx.application.sys.mapper.MenuMapper;
import com.xxx.application.sys.service.IMenuService;
import com.xxx.application.util.R;


/**
 * <p>
 * 菜单表 前端控制器
 * </p>
 *
 * @author zyk
 * @since 2019-08-06
 */
@RestController
@RequestMapping("/sys/menu")
public class MenuController {
	@Autowired
	private IMenuService menuService;
	@Autowired
	private MenuMapper menuMapper;
	
	@RequestMapping("/select")
	public R selectAll(){
		Map<String, Object> map = menuService.getMap(null);
		QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
		List<Menu> list = menuMapper.selectList(null);
		for (Menu menu : list) {
			System.out.println(menu);
		}
		Map<String, Object> map1 = new HashMap<>();
		map1.put("data", list);
		return R.ok(map1);
	}
	
	
}
