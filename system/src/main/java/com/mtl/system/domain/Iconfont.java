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
 * @since 2019-04-03
 */
@Data
@Table(name="mtl_iconfont")
@ApiModel(value = "Iconfont对象", description = "Iconfont对象")

public class Iconfont implements Serializable {

    private static final long serialVersionUID = 1L;


  private Integer id;

  private String name;


}
