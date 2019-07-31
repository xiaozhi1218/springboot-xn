package com.mtl.system.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;
import java.time.LocalDate;

@Data
@ApiModel(value = "UserVO对象", description = "UserVO对象")
public class UserVo {

    /**
     * 编号
     */
    @ApiModelProperty(value = "编号")
    @Id

    private Integer userid;
    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")

    private String username;

    /**
     * 电话
     */
    @ApiModelProperty(value = "电话")

    private String phone;
    /**
     * 用户图像
     */
    @ApiModelProperty(value = "用户图像")

    private String avatar;
    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")

    private Integer state;
    /**
     * 真实姓名
     */
    @ApiModelProperty(value = "真实姓名")

    private String realname;
   /* *//**
     * 部门id
     *//*
    @ApiModelProperty(value = "部门id")

    private Integer deptId;*/
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")

    private String remark;
    /**
     * 创建日期
     */
    @ApiModelProperty(value = "创建日期")

    private LocalDate createTime;
    /**
     * 创建者
     */
    @ApiModelProperty(value = "创建者")

    private Integer creator;

    @ApiModelProperty(value = "创建者名")
    private String creatorName;

    /**
     * 区域id
     */
    @ApiModelProperty(value = "区域id")

    private Integer regionsId;
    /**
     * 区域名称
     */
    @ApiModelProperty(value = "区域名称")

    private transient String regionsName;
    /**
     * 区域负责人:0：普通用户；>0：区域负责人
     */
    @ApiModelProperty(value = "区域负责人")

    private transient Integer isRegionAdmin;
}
