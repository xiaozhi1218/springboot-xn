package com.mtl.system.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import com.mtl.common.tool.api.R;
import com.mtl.common.tool.model.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.mtl.system.domain.Role;
import com.mtl.system.service.IRoleService;
import java.util.List;
import java.util.Arrays;

/**
 * 角色表 控制器
 *
 * @author lsc
 * @since 2019-04-14
 */
@RestController
@RequestMapping("/admin/role")
@Api(value = "角色表", tags = "角色表接口")
public class RoleController {

	@Autowired
	private IRoleService roleService;

	/**
	* 详情
	*/
	@GetMapping("/detail")
	@ApiOperation(value = "详情", notes = "传入role", position = 1)
	public R<Role> detail(Integer id) {
		Role detail = roleService.findById(id);
		return R.data(detail);
	}

	/**
	* 分页 角色表
	*/
	@GetMapping("/page")
	@ApiOperation(value = "分页", notes = "传入role", position = 2)
	public R<Page<Role>> page(Integer page,Integer size,String search) {
		Page<Role> pages = roleService.findPage(page,size,search);
		return R.data(pages);
	}

	/**
	* 新增或修改 角色表
	*/
	@PostMapping("/submit")
	@ApiOperation(value = "新增或修改", notes = "传入role", position = 6)
	public R submit(@RequestBody Role role) {
		return R.status(roleService.saveOrUpdate(role));
	}

	/**
	* 删除 角色表
	*/
	@PostMapping("/remove")
	@ApiOperation(value = "删除", notes = "传入ids", position = 7)
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestBody Integer[] ids) {
		return R.status(roleService.deleteBatch(Arrays.asList(ids)));
	}

}
