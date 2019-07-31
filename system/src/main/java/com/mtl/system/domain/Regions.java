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
 * 实体类
 *
 * @author lsc
 * @since 2019-04-14
 */
@Data
@Table(name="mtl_regions")
@ApiModel(value = "Regions对象", description = "Regions对象")

public class Regions implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 区域id
     */
    @ApiModelProperty(value = "区域id")
    @Id


  private Integer id;
    /**
     * 父级区域id
     */
    @ApiModelProperty(value = "父级区域id")
  
  private Integer parentId;
    /**
     * 区域路径
     */
    @ApiModelProperty(value = "区域路径")
  
  private String regionPath;
    /**
     * 区域等级
     */
    @ApiModelProperty(value = "区域等级")
  
  private Integer regionGrade;
    /**
     * 本地名称
     */
    @ApiModelProperty(value = "本地名称")
  
  private String localName;
    /**
     * 邮编
     */
    @ApiModelProperty(value = "邮编")
  
  private String zipcode;
    /**
     * 区域负责人id
     */
    @ApiModelProperty(value = "区域负责人id")
  
  private Integer adminUserId;


}
