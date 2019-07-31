package com.mtl.system.domain.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mtl.common.tool.node.INode;
import com.mtl.system.domain.Menu;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 视图实体类
 *
 * @author Chill
 */
@Data
@ApiModel(value = "MenuVO对象", description = "MenuVO对象")
public class MenuVO implements INode {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
	private Integer id;

	/**
	 * 父节点ID
	 */
	private Integer parentId;


	private String name;

	private Integer type;

	private String path;

	private String icon;
	private Boolean checked;

	private String menuButtons;
	private String act;
	private Boolean checkedAll;
	private Boolean isIndeterminate;
	private String permission;
	private List<String> selectchecked;
	private List<Map> listMenuButtons;
	/**
	 * 子孙节点
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<INode> children;

	@Override
	public List<INode> getChildren() {
		if (this.children == null) {
			this.children = new ArrayList<>();
		}
		return this.children;
	}

	/*
	* 如果角色有该菜单权限为1，没有权限为0
	* */
	public  transient Integer isAuth;

}
