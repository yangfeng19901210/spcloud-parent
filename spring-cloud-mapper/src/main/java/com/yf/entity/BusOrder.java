package com.yf.entity;


import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * @author: yangfeng
 * @date: 2022-11-14 10:38:33
 * @description: 订单信息表(BusOrder)实体类
 */
@Data
@ApiModel(value = "订单信息表实体类")
public class BusOrder extends Model<BusOrder> implements Serializable {
    private static final long serialVersionUID = -33309107828535824L;

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ApiModelProperty("主键")
    private Integer id;

    /**
     * 订单编号
     */

    @ApiModelProperty("订单编号")
    private String ordNo;

    /**
     * 商品名称
     */

    @ApiModelProperty("商品名称")
    private String goodsName;

    /**
     * 商品规格
     */

    @ApiModelProperty("商品规格")
    private String spec;

    /**
     * 用户id
     */

    @ApiModelProperty("用户id")
    private Integer userId;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty("创建时间")
    private Date createTime;

    /**
     * 更新时间
     * FieldFill.INSERT 新增是会对时间进行处理
     * FieldFill.INSERT_UPDATE 新增和修改都会对时间进行处理
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty("更新时间")
    private Date updateTime;

    /**
     * 创建人
     */
    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty("创建人")
    private String createBy;

    /**
     * 更新人
     */
    @TableField(fill = FieldFill.UPDATE)
    @ApiModelProperty("更新人")
    private String updateBy;

    /**
     * 删除标识
     */
    @TableLogic(value = "0", delval = "1")
    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty("删除标识")
    private Integer isDelete;

}
