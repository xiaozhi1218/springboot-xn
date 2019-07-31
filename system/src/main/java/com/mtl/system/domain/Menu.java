package com.mtl.system.domain;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 实体类
 *
 * @author lsc
 * @since 2019-03-26
 */
@Data
@Table(name = "mtl_menu")
@ApiModel(value = "Menu对象", description = "Menu对象")
public class Menu implements Serializable {
    private static final long serialVersionUID = 1L;

  @Id
  private Integer id;
  private Integer pid;
  private String title;
  private String url;
  private Integer sorder;
  private Integer type;
  private String datatype;
  private Integer checked;
  private Integer deleteflag;
  private Integer canexp;
  private String icon;
  private String iconHover;
  private Integer isDisplay;
  private String permission;//主url
  private String menuButtons;//菜单功能


  public Integer getId() {
    return id;
  }

  public void setDeleteflag(Integer deleteflag) {
    this.deleteflag = deleteflag;
  }

  public void setIsDisplay(Integer isDisplay) {
    this.isDisplay = isDisplay;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setPid(Integer pid) {
    this.pid = pid;
  }

  public Integer getPid() {
    return pid;
  }
}
