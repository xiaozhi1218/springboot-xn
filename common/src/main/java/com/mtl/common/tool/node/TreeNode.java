package com.mtl.common.tool.node;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 树型节点类
 *
 * @author Chill
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TreeNode extends BaseNode {

	private Integer id;

	private String label;

}
