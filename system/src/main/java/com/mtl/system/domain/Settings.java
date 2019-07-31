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
 * @since 2019-03-26
 */
@Data
@Table(name="mtl_settings")
@ApiModel(value = "Settings对象", description = "Settings对象")

public class Settings implements Serializable {

    private static final long serialVersionUID = 1L;

  @Id

  private Integer id;

  private String code;

  private String cfgValue;

  private String cfgGroup;


}
