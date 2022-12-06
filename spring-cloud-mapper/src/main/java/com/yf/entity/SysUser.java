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
 * @date: 2022-11-10 16:13:13
 * @description: 用户信息表(SysUser)实体类
 */
@Data
@ApiModel(value = "用户信息表实体类")
public class SysUser extends Model<SysUser> implements Serializable {
    private static final long serialVersionUID = -92526619733829979L;

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ApiModelProperty("主键")
    private Integer id;

    /**
     * 姓名
     */

    @ApiModelProperty("姓名")
    private String name;

    /**
     * 年龄
     */

    @ApiModelProperty("年龄")
    private Integer age;

    /**
     * 性别
     */

    @ApiModelProperty("性别")
    private String sex;

    /**
     * 薪资
     */

    @ApiModelProperty("薪资")
    private Double salary;

    /**
     * 出生年月
     */

    @ApiModelProperty("出生年月")
    private String dateOfBirth;

    /**
     * 住址
     */

    @ApiModelProperty("住址")
    private String address;

    /**
     * 状态
     */

    @ApiModelProperty("状态")
    private String status;

    /**
     * 服务流程
     */

    @ApiModelProperty("服务流程")
    private String serviceProcess;

}
