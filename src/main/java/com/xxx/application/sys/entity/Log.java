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
 * 日志表
 * </p>
 *
 * @author zyk
 * @since 2019-08-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_log")
public class Log implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value="id",type=IdType.UUID)
    private String id;

    /**
     * 用户
     */
    @TableField("userName")
    private String userName;

    /**
     * 日志
     */
    private String title;

    /**
     * 地址
     */
    private String url;

    /**
     * 参数
     */
    private String params;

    /**
     * 日志时间
     */
    @TableField("createTime")
    private LocalDateTime createTime;


}
