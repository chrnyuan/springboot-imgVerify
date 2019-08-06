package com.xxx.application.sys.service.impl;

import com.xxx.application.sys.entity.UserRole;
import com.xxx.application.sys.mapper.UserRoleMapper;
import com.xxx.application.sys.service.IUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色关联表 服务实现类
 * </p>
 *
 * @author zyk
 * @since 2019-08-06
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}
