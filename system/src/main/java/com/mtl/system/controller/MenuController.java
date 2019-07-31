package com.mtl.system.controller;

import com.mtl.common.tool.api.R;
import com.mtl.common.tool.utils.JwtUtil;
import com.mtl.system.domain.Menu;
import com.mtl.system.service.IMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 *  控制器
 *
 * @author lsc
 * @since 2019-03-26
 */
@RestController
@AllArgsConstructor
@RequestMapping("/admin/menu")
@Api(value = "菜单管理", tags = "菜单管理")
public class MenuController {

	private IMenuService menuService;


	/**
	* 详情
	*/
	@GetMapping("/detail")
	@ApiOperation(value = "详情", notes = "传入menu", position = 1)
	public R<Menu> detail(Integer id) {
		Menu detail = menuService.findById(id);
		return R.data(detail);
	}

	/**
	* 新增或修改 
	*/
	@PostMapping("/saveOrUpdate")
	@ApiOperation(value = "新增或修改", notes = "传入menu", position = 6)
	public R submit(@Valid @RequestBody Menu menu) {
		return R.status(menuService.saveOrUpdate(menu));
	}

	
	/**
	* 删除 
	*/
	@PostMapping("/delete/{id}")
	@ApiOperation(value = "删除", notes = "传入id", position = 7)
	public R remove(@ApiParam(value = "主键id", required = true) @PathVariable Integer id) {
		int f=menuService.delete(id);
		if(f>0) {
            return R.success("删除成功！");
        } else if(f==0) {
            return R.fail("删除失败！");
        } else {
            return R.fail("请先删除子菜单！");
        }
	}

	/*
	获取菜单
	* */
	@GetMapping("/tree")
	@ApiOperation(value = "获取用户菜单树", notes = "获取用户菜单树", position = 8)
	public R roleMenuTree(){
		Integer id = JwtUtil.getUserId();
		return R.data(menuService.authMenuTree(id));
	}

	/*
	获取角色权限
	* */
	@GetMapping("/MenuTreeByRole")
	@ApiOperation(value = "获取用户菜单树", notes = "获取用户菜单树", position = 8)
	public R MenuTreeByRole(Integer roleId){
		return R.data(menuService.MenuTreeByRole(roleId));
	}
}
