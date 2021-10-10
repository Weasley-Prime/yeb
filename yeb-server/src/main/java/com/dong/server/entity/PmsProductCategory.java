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
 * 产品分类
 * </p>
 *
 * @author wangzedong
 * @since 2021-10-10 22:33:59
 */
@Getter
@Setter
@TableName("pms_product_category")
@ApiModel(value = "PmsProductCategory对象", description = "产品分类")
public class PmsProductCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("分类id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("上机分类的编号：0表示一级分类")
    private Long parentId;

    @ApiModelProperty("分类名称")
    private String name;

    @ApiModelProperty("分类级别：0->1级；1->2级")
    private Integer level;

    @ApiModelProperty("产品数量")
    private Integer productCount;

    private String productUnit;

    @ApiModelProperty("是否显示在导航栏：0->不显示；1->显示")
    private Integer navStatus;

    @ApiModelProperty("显示状态：0->不显示；1->显示")
    private Integer showStatus;

    private Integer sort;

    @ApiModelProperty("图标")
    private String icon;

    private String keywords;

    @ApiModelProperty("描述")
    private String description;


}
