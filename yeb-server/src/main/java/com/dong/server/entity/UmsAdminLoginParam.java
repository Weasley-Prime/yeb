package com.dong.server.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户登录实体类
 *
 * @author: wangzedong
 * @since: 1.0.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "AdminLogin对象")
public class UmsAdminLoginParam {
    @ApiModelProperty(value = "用户名",required = true)
    private String username;

    @ApiModelProperty(value = "密码",required = true)
    private String password;
}
