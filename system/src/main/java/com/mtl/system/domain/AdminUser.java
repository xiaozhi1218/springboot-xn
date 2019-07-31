package com.mtl.system.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 平台用户实体类
 *
 * @author lsc
 * @since 2019-03-27
 */
@Data
@Table(name = "mtl_adminuser")
@ApiModel(value = "AdminUser对象", description = "平台用户")

public class AdminUser implements Serializable {

    private static final long serialVersionUID = 1L;

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
     * 密码
     */
    @ApiModelProperty(value = "密码")
    @JsonIgnore
    private String password;
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
     * 区域负责人
     */
    @ApiModelProperty(value = "区域负责人")

    private transient Integer isRegionAdmin;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")

    private String remark;
    /**
     * 创建日期
     */
    @ApiModelProperty(value = "创建日期")

    private Date createTime;
    /**
     * 创建者
     */
    @ApiModelProperty(value = "创建者")

    private Integer creator;

    private  Role role;

    private List<Menu> permissions;
}
