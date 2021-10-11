package com.dong.server.service.impl;

import com.dong.server.entity.TMailLog;
import com.dong.server.mapper.TMailLogMapper;
import com.dong.server.service.ITMailLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wangzedong
 * @since 2021-10-11 23:09:24
 */
@Service
public class TMailLogServiceImpl extends ServiceImpl<TMailLogMapper, TMailLog> implements ITMailLogService {

}
