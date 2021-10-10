package com.dong.server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 订单中所包含的商品
 * </p>
 *
 * @author wangzedong
 * @since 2021-10-10 22:33:59
 */
@Getter
@Setter
@TableName("oms_order_item")
@ApiModel(value = "OmsOrderItem对象", description = "订单中所包含的商品")
public class OmsOrderItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("订单详细信息id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("订单id")
    private Long orderId;

    @ApiModelProperty("订单编号")
    private String orderSn;

    @ApiModelProperty("产品id")
    private Long productId;

    private String productPic;

    @ApiModelProperty("产品名字")
    private String productName;

    @ApiModelProperty("产品品牌")
    private String productBrand;

    private String productSn;

    @ApiModelProperty("销售价格")
    private BigDecimal productPrice;

    @ApiModelProperty("购买数量")
    private Integer productQuantity;

    @ApiModelProperty("商品sku编号")
    private Long productSkuId;

    @ApiModelProperty("商品sku条码")
    private String productSkuCode;

    @ApiModelProperty("商品分类id")
    private Long productCategoryId;

    @ApiModelProperty("商品的销售属性")
    private String sp1;

    private String sp2;

    private String sp3;

    @ApiModelProperty("商品促销名称")
    private String promotionName;

    @ApiModelProperty("商品促销分解金额")
    private BigDecimal promotionAmount;

    @ApiModelProperty("优惠券优惠分解金额")
    private BigDecimal couponAmount;

    @ApiModelProperty("积分优惠分解金额")
    private BigDecimal integrationAmount;

    @ApiModelProperty("该商品经过优惠后的分解金额")
    private BigDecimal realAmount;

    private Integer giftIntegration;

    private Integer giftGrowth;

    @ApiModelProperty("商品销售属性:[{\"key\":\"颜色\",\"value\":\"颜色\"},{\"key\":\"容量\",\"value\":\"4G\"}]")
    private String productAttr;


}
