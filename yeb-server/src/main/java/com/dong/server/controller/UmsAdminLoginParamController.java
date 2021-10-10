package com.dong.server.controller;

import com.dong.server.entity.RespBean;
import com.dong.server.entity.UmsAdminLoginParam;
import com.dong.server.service.IUmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户登录控制类
 *
 * @author: wangzedong
 * @since: 1.0.0
 */

@Api(value = "用户登录")
@RestController
public class UmsAdminLoginParamController {

    @Autowired
    private IUmsAdminService iUmsAdminService;
    @ApiOperation(value = "登录之后返回token")
    @PostMapping("/login")
    public RespBean login(UmsAdminLoginParam umsAdminLoginParam, HttpServletRequest httpServletRequest){
        return iUmsAdminService.login(umsAdminLoginParam.getUsername(),umsAdminLoginParam.getPassword(),httpServletRequest);
    }
}
