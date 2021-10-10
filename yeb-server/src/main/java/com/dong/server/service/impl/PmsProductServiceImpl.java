package com.dong.server.service.impl;

import com.dong.server.entity.PmsProduct;
import com.dong.server.mapper.PmsProductMapper;
import com.dong.server.service.IPmsProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品信息 服务实现类
 * </p>
 *
 * @author wangzedong
 * @since 2021-10-10 22:33:59
 */
@Service
public class PmsProductServiceImpl extends ServiceImpl<PmsProductMapper, PmsProduct> implements IPmsProductService {

}
