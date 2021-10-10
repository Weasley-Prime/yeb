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
 * 后台用户和权限关系表(除角色中定义的权限以外的加减权限)
 * </p>
 *
 * @author wangzedong
 * @since 2021-10-10 22:33:59
 */
@Getter
@Setter
@TableName("ums_admin_permission_relation")
@ApiModel(value = "UmsAdminPermissionRelation对象", description = "后台用户和权限关系表(除角色中定义的权限以外的加减权限)")
public class UmsAdminPermissionRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户权限关系id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("用户id")
    private Long adminId;

    @ApiModelProperty("权限id")
    private Long permissionId;

    @ApiModelProperty("权限类型")
    private Integer type;


}
