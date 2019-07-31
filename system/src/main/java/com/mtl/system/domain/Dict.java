package com.mtl.system.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 实体类
 *
 * @author lsc
 * @since 2019-04-08
 */
@Data
@Table(name="mtl_dict")
@ApiModel(value = "Dict对象", description = "Dict对象")

public class Dict implements Serializable {

    private static final long serialVersionUID = 1L;

  @Id

  private Integer id;
    /**
     * 创建者
     */
    @ApiModelProperty(value = "创建者")
  
  private String createBy;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
  
  private Date createTime;
    /**
     * 是否删除
     */
    @ApiModelProperty(value = "是否删除")
  
  private Integer delFlag;
    /**
     * 修改者
     */
    @ApiModelProperty(value = "修改者")
  
  private String updateBy;
    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间")
  
  private Date updateTime;
    /**
     * 描述
     */
    @ApiModelProperty(value = "描述")
  
  private String description;
    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
  
  private String title;
    /**
     * 类型
     */
    @ApiModelProperty(value = "类型")
  
  private String type;
    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
  
  private BigDecimal sortOrder;


}
