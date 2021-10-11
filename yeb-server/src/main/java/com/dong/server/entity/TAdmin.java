package com.dong.server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author wangzedong
 * @since 2021-10-11 23:09:23
 */
@Getter
@Setter
@TableName("t_admin")
@ApiModel(value = "TAdmin对象", description = "")
public class TAdmin implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("手机号码")
    private String phone;

    @ApiModelProperty("住宅电话")
    private String telephone;

    @ApiModelProperty("联系地址")
    private String address;

    @ApiModelProperty("是否启用")
    private Boolean enabled;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("用户头像")
    private String userFace;

    @ApiModelProperty("备注")
    private String remark;


}
