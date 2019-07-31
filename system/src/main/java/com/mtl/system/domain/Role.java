package com.mtl.system.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import java.io.Serializable;
/**
 * 角色表实体类
 *
 * @author lsc
 * @since 2019-04-14
 */
@Data
@Table(name="mtl_role")
@ApiModel(value = "Role对象", description = "角色表")

public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色id
     */
    @ApiModelProperty(value = "角色id")
    @Id

  private Integer roleId;
    /**
     * 角色名
     */
    @ApiModelProperty(value = "角色名")

  private String roleName;
    /**
     * 所属区域id
     */
    @ApiModelProperty(value = "所属区域id")

  private String regionsId;


    /**
     * 所属区域
     */
    @ApiModelProperty(value = "所属区域id")

    private transient String regionsName;

    private String authAction;
    private String authUrl;//url

}
