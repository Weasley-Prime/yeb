package com.dong.server.service;

import com.dong.server.dto.CommonResult;
import com.dong.server.entity.AdminLoginParam;
import com.dong.server.entity.TAdmin;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wangzedong
 * @since 2021-10-11 23:09:23
 */
public interface ITAdminService extends IService<TAdmin> {
    TAdmin getAdminByUserName(String username);

    CommonResult login(String username, String password,String code, HttpServletRequest request);
}
