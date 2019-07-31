package com.mtl.system.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import com.mtl.common.tool.api.R;
import com.mtl.common.tool.model.Page;
import org.springframework.web.bind.annotation.*;
import com.mtl.system.domain.Settings;
import com.mtl.system.service.ISettingsService;
import java.util.List;
import java.util.Arrays;

/**
 *  控制器
 *
 * @author lsc
 * @since 2019-03-26
 */
@RestController
@RequestMapping("/admin/settings")
@Api(value = "系统设置", tags = "系统设置")
public class SettingsController {

	private ISettingsService settingsService;

	/**
	* 详情
	*/
	@GetMapping("/detail")
	@ApiOperation(value = "详情", notes = "传入settings", position = 1)
	public R<Settings> detail(Integer id) {
		Settings detail = settingsService.findById(id);
		return R.data(detail);
	}

	/**
	* 分页 
	*/
	@GetMapping("/page")
	@ApiOperation(value = "分页", notes = "传入settings", position = 2)
	public R<Page<Settings>> page(Integer page,Integer size) {
		Page<Settings> pages = settingsService.findPage(page,size);
		return R.data(pages);
	}

	/**
	* 新增或修改 
	*/
	@PostMapping("/submit")
	@ApiOperation(value = "新增或修改", notes = "传入settings", position = 6)
	public R submit(@RequestBody Settings settings) {
		return R.status(settingsService.saveOrUpdate(settings));
	}

	/**
	* 删除 
	*/
	@PostMapping("/remove")
	@ApiOperation(value = "删除", notes = "传入ids", position = 7)
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestBody Integer[] ids) {
		return R.status(settingsService.deleteBatch(Arrays.asList(ids)));
	}

}
