package com.mtl.system.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import com.mtl.common.tool.api.R;
import com.mtl.common.tool.model.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.mtl.system.domain.Dict;
import com.mtl.system.service.IDictService;
import java.util.List;
import java.util.Arrays;

/**
 *  控制器
 *
 * @author lsc
 * @since 2019-04-08
 */
@RestController
@RequestMapping("/admin/dict")
@Api(value = "", tags = "接口")
public class DictController {

	@Autowired
	private IDictService dictService;

	/**
	* 详情
	*/
	@GetMapping("/detail")
	@ApiOperation(value = "详情", notes = "传入dict", position = 1)
	public R<Dict> detail(Integer id) {
		Dict detail = dictService.findById(id);
		return R.data(detail);
	}

	/**
	* 分页 
	*/
	@GetMapping("/list")
	@ApiOperation(value = "分页", notes = "分页", position = 2)
	public R<List<Dict>> page() {
		List<Dict> pages = dictService.list();
		return R.data(pages);
	}

	/**
	* 新增或修改 
	*/
	@PostMapping("/submit")
	@ApiOperation(value = "新增或修改", notes = "传入dict", position = 6)
	public R submit(@RequestBody Dict dict) {
		return R.status(dictService.saveOrUpdate(dict));
	}

	/**
	* 删除 
	*/
	@PostMapping("/remove")
	@ApiOperation(value = "删除", notes = "传入ids", position = 7)
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestBody Integer[] ids) {
		return R.status(dictService.deleteBatch(Arrays.asList(ids)));
	}

}
