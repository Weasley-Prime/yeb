package com.dong.server.service.impl;

import com.dong.server.entity.OmsOrderItem;
import com.dong.server.mapper.OmsOrderItemMapper;
import com.dong.server.service.IOmsOrderItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单中所包含的商品 服务实现类
 * </p>
 *
 * @author wangzedong
 * @since 2021-10-10 22:33:59
 */
@Service
public class OmsOrderItemServiceImpl extends ServiceImpl<OmsOrderItemMapper, OmsOrderItem> implements IOmsOrderItemService {

}
