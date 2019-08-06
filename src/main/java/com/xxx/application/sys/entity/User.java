package com.xxx.application.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author zyk
 * @since 2019-08-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value="id",type=IdType.UUID)
    private String id;

    /**
     * 用户名
     */
    @TableField("userName")
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户状态,1-启用,-1禁用
     */
    @TableField("userState")
    private Integer userState;

    /**
     * 创建时间
     */
    @TableField("createTime")
    private LocalDateTime createTime;

    /**
     * 描述
     */
    @TableField("userDesc")
    private String userDesc;

    /**
     * 头像
     */
    @TableField("userImg")
    private String userImg;

    /**
     * 部门主键
     */
    @TableField("deptId")
    private String deptId;


}
