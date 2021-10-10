package com.dong.server.service.impl;

import com.dong.server.entity.OmsOrder;
import com.dong.server.mapper.OmsOrderMapper;
import com.dong.server.service.IOmsOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author wangzedong
 * @since 2021-10-10 22:33:59
 */
@Service
public class OmsOrderServiceImpl extends ServiceImpl<OmsOrderMapper, OmsOrder> implements IOmsOrderService {

}
