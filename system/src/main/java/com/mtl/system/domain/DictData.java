package com.mtl.system.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 实体类
 *
 * @author lsc
 * @since 2019-04-08
 */
@Data
@Table(name="mtl_dict_data")
@ApiModel(value = "DictData对象", description = "DictData对象")

public class DictData implements Serializable {

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
     * 字典id
     */
    @ApiModelProperty(value = "字典id")
  
  private Integer dictId;
    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
  
  private BigDecimal sortOrder;
    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
  
  private Integer status;
    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
  
  private String title;
    /**
     * 值
     */
    @ApiModelProperty(value = "值")
  
  private String value;


}
