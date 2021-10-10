package com.dong.server.service.impl;

import com.dong.server.entity.UmsAdminPermissionRelation;
import com.dong.server.mapper.UmsAdminPermissionRelationMapper;
import com.dong.server.service.IUmsAdminPermissionRelationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户和权限关系表(除角色中定义的权限以外的加减权限) 服务实现类
 * </p>
 *
 * @author wangzedong
 * @since 2021-10-10 22:33:59
 */
@Service
public class UmsAdminPermissionRelationServiceImpl extends ServiceImpl<UmsAdminPermissionRelationMapper, UmsAdminPermissionRelation> implements IUmsAdminPermissionRelationService {

}
