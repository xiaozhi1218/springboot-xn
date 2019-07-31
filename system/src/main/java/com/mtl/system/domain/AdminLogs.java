package com.mtl.system.domain;


import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 实体类
 *
 * @author lsc
 * @since 2019-03-26
 */
@Data
@Table(name = "mtl_admin_logs")
@ApiModel(value = "AdminLogs对象", description = "AdminLogs对象")
public class AdminLogs implements Serializable {

    private static final long serialVersionUID = 1L;

  @Id
  private Long logId;
  private String logType;
  private String operatorName;
  private Integer operatorId;
  private String logDetail;
  private Long logTime;


}
