package com.mtl.system.controller;

import com.mtl.common.tool.utils.JwtUtil;
import com.mtl.system.domain.vo.RegionsVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import com.mtl.common.tool.api.R;
import com.mtl.common.tool.model.Page;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.mtl.system.domain.Regions;
import com.mtl.system.service.IRegionsService;
import java.util.List;
import java.util.Arrays;

/**
 *  控制器
 *
 * @author lsc
 * @since 2019-04-14
 */
@RestController
@AllArgsConstructor
@RequestMapping("/admin/regions")
@Api(value = "区域管理", tags = "接口")
public class RegionsController {

	@Autowired
	private IRegionsService regionsService;



	/**
	* 分页 
	*/
	@GetMapping("/page")
	@ApiOperation(value = "分页", notes = "传入regions", position = 2)
	public R<Page<Regions>> page(Integer page,Integer size) {
		Page<Regions> pages = regionsService.findPage(page,size);
		return R.data(pages);
	}

	/**
	 * 新增或修改
	 */
	@PostMapping("/submit")
	@ApiOperation(value = "新增或修改", notes = "传入regions", position = 6)
	public R submit(@RequestBody Regions regions) {
		return R.status(regionsService.saveOrUpdate(regions));
	}

	/**
	 * 新增或修改树
	 */
	@PostMapping("/saveOrUpdate")
	@ApiOperation(value = "新增或修改", notes = "传入regions", position = 6)
	public R saveOrUpdate(@RequestBody Regions regions) {
		return R.status(regionsService.saveOrUpdateRegionsVO (regions));
	}

	/**
	 * 删除区域
	 */
	@PostMapping("/deleteRegions")
	@ApiOperation(value = "删除区域", notes = "传入regions", position = 6)
	public R deleteRegions(@RequestBody Regions regions) {
		int state= regionsService.deleteRegionsVO(regions);
		if(state==0){
			R r=R.fail("区域存在关联用户，无法删除，请先修改用户");
			return r;
		}
		else {
			R r=R.success("删除成功");
			return r;
		}

	}

	/**
	* 删除 
	*/
	@PostMapping("/remove")
	@ApiOperation(value = "删除", notes = "传入ids", position = 7)
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestBody Integer[] ids) {
		return R.status(regionsService.deleteBatch(Arrays.asList(ids)));
	}

	/**
	 * 删除
	 */
	@PostMapping("/delete/{id}")
	@ApiOperation(value = "删除", notes = "传入id", position = 7)
	public R remove(@ApiParam(value = "主键id", required = true) @PathVariable Integer id) {
		int f=regionsService.delete(id);
		if(f>0) {
            return R.success("删除成功！");
        } else if(f==0) {
            return R.fail("删除失败！");
        } else {
            return R.fail("请先删除子菜单！");
        }
	}

	@GetMapping("/tree")
	@ApiOperation(value = "获取用户区域树", notes = "获取用户区域树", position = 8)
	public R regionsTree(){
		Integer id = JwtUtil.getUserId();
		return R.data(regionsService.regionsTree(id));
	}

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperation(value = "详情", notes = "传入menu", position = 1)
	public R detail(Integer id) {
		return R.data(regionsService.regions(id));
	}

}
