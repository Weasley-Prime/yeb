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
 * 
 * </p>
 *
 * @author wangzedong
 * @since 2021-10-11 23:09:24
 */
@Getter
@Setter
@TableName("t_position")
@ApiModel(value = "TPosition对象", description = "")
public class TPosition implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("职位")
    private String name;

    @ApiModelProperty("创建时间")
    private LocalDateTime createDate;

    @ApiModelProperty("是否启用")
    private Boolean enabled;


}
