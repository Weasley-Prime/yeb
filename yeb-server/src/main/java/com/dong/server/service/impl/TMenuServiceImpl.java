package com.dong.server.service.impl;

import com.dong.server.entity.TAdmin;
import com.dong.server.entity.TMenu;
import com.dong.server.mapper.TMenuMapper;
import com.dong.server.service.ITMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wangzedong
 * @since 2021-10-11 23:09:24
 */
@Service
public class TMenuServiceImpl extends ServiceImpl<TMenuMapper, TMenu> implements ITMenuService {

    private final TMenuMapper mapper;
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    public TMenuServiceImpl(TMenuMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<TMenu> getMenuByAdminId() {
        Integer adminId = ((TAdmin) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        List<TMenu> menus = (List) valueOperations.get("menu_" + adminId);
        if (CollectionUtils.isEmpty(menus)) {
            menus = mapper.getMenuByAdminId(adminId);
            valueOperations.set("menu_"+adminId,menus);
        }
        return menus;
    }

    @Override
    public List<TMenu> getMenuByRole() {
        return mapper.getMenuByRole();
    }
}
