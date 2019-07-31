package com.mtl.system.domain.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mtl.common.tool.node.INode;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 视图实体类
 *
 * @author Chill
 */
@Data
@ApiModel(value = "RegionsVO对象", description = "RegionsVO对象")
public class RegionsVO implements INode {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
	private Integer id;

	/**
	 * 父节点ID
	 */
	private Integer parentId;

	/*父级菜单名*/
	private  String parentRegions;

	private String localName;

	private Integer regionGrade;

	private String regionPath;

	private String zipcode;

	private Integer adminUserId;
	/*用户名*/
	private  String adminUserName;

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

}
