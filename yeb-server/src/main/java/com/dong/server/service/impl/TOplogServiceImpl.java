package com.dong.server.service.impl;

import com.dong.server.entity.TOplog;
import com.dong.server.mapper.TOplogMapper;
import com.dong.server.service.ITOplogService;
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
public class TOplogServiceImpl extends ServiceImpl<TOplogMapper, TOplog> implements ITOplogService {

}
