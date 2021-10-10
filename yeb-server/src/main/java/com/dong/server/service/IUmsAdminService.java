package com.dong.server.service;

import com.dong.server.entity.RespBean;
import com.dong.server.entity.UmsAdmin;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author wangzedong
 * @since 2021-10-10 22:33:59
 */
public interface IUmsAdminService extends IService<UmsAdmin> {

    /**
     * 登录之后返回token
     * @param username
     * @param password
     * @param httpServletRequest
     * @return
     */
    RespBean login(String username, String password, HttpServletRequest httpServletRequest);
}
