package com.dong.server.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 *  用户登录前端返回类型
 * </p>
 *
 * @author wangzedong
 * @since 2021-10-11 23:09:24
 */
@Data
@ApiModel(value = "AdminLogin对象")
public class AdminLoginParam {
    @ApiModelProperty(value = "用户名",required = true)
    private String username;
    @ApiModelProperty(value = "密码",required = true)
    private String password;
    @ApiModelProperty(value = "验证码",required = true)
    private String code;
}
