package com.dong.server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 后台用户角色表
 * </p>
 *
 * @author wangzedong
 * @since 2021-10-10 22:33:59
 */
@Getter
@Setter
@TableName("ums_role")
@ApiModel(value = "UmsRole对象", description = "后台用户角色表")
public class UmsRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("角色id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("后台用户数量")
    private Integer adminCount;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("启用状态：0->禁用；1->启用")
    private Integer status;

    private Integer sort;


}
