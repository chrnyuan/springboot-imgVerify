package com.xxx.application.sys.service.impl;

import com.xxx.application.sys.entity.Log;
import com.xxx.application.sys.mapper.LogMapper;
import com.xxx.application.sys.service.ILogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 日志表 服务实现类
 * </p>
 *
 * @author zyk
 * @since 2019-08-06
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements ILogService {

}
