package com.dong.server.controller;

import com.dong.server.dto.CommonResult;
import com.dong.server.entity.AdminLoginParam;
import com.dong.server.entity.TAdmin;
import com.dong.server.service.ITAdminService;
import com.sun.org.glassfish.gmbal.ParameterNames;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * <p>
 * 用户登录前端控制器
 * </p>
 *
 * @author wangzedong
 * @since 2021/10/12
 */
@RestController
@Api(value = "用户登录")
public class AdminLoginController {
    private final ITAdminService adminService;

    public AdminLoginController(ITAdminService adminService) {
        this.adminService = adminService;
    }

    @ApiOperation(value = "用户登录，返回token")
    @PostMapping("/login")
    public CommonResult login(
            @Param("用户登录类") @RequestBody AdminLoginParam adminLoginParam, HttpServletRequest httpServletRequest){
        return adminService.login(adminLoginParam.getUsername(),adminLoginParam.getPassword(),adminLoginParam.getCode(),httpServletRequest);
    }

    @ApiOperation(value = "获取当前用户信息")
    @PostMapping("/admin/info")
    private TAdmin getAdminInfo(Principal principal){
        if(null == principal){
            return null;
        }
        String username = principal.getName();
        TAdmin admin = adminService.getAdminByUserName(username);
        admin.setPassword(null);
        return admin;
    }


    @ApiOperation(value = "退出登录")
    @PostMapping("/logout")
    private CommonResult logout(){
        return CommonResult.success("退出成功");
    }

    @ApiOperation(value = "退出登录")
    @PostMapping("/message")
    private CommonResult message(){
        return CommonResult.success("退出成功");
    }
}
