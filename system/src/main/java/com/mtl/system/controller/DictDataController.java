package com.mtl.system.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import com.mtl.common.tool.api.R;
import com.mtl.common.tool.model.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.mtl.system.domain.DictData;
import com.mtl.system.service.IDictDataService;
import java.util.List;
import java.util.Arrays;

/**
 *  控制器
 *
 * @author lsc
 * @since 2019-04-08
 */
@RestController
@RequestMapping("/admin/dictdata")
@Api(value = "", tags = "接口")
public class DictDataController {

	@Autowired
	private IDictDataService dictDataService;

	/**
	* 详情
	*/
	@GetMapping("/detail")
	@ApiOperation(value = "详情", notes = "传入dictData", position = 1)
	public R<DictData> detail(Integer id) {
		DictData detail = dictDataService.findById(id);
		return R.data(detail);
	}

	/**
	* 分页 
	*/
	@GetMapping("/page")
	@ApiOperation(value = "分页", notes = "传入dictData", position = 2)
	public R<Page<DictData>> page(Integer page,Integer size,Integer id) {
		Page<DictData> pages = dictDataService.findPage(page,size,id);
		return R.data(pages);
	}

	/**
	* 新增或修改 
	*/
	@PostMapping("/submit")
	@ApiOperation(value = "新增或修改", notes = "传入dictData", position = 6)
	public R submit(@RequestBody DictData dictData) {
		return R.status(dictDataService.saveOrUpdate(dictData));
	}

	/**
	* 删除 
	*/
	@PostMapping("/remove")
	@ApiOperation(value = "删除", notes = "传入ids", position = 7)
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestBody Integer[] ids) {
		return R.status(dictDataService.deleteBatch(Arrays.asList(ids)));
	}

}
