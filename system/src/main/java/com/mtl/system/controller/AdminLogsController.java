package com.mtl.system.controller;

import com.mtl.common.tool.api.R;
import com.mtl.common.tool.model.Page;
import com.mtl.common.tool.utils.Func;
import com.mtl.system.domain.AdminLogs;
import com.mtl.system.service.IAdminLogsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;


/**
 *  控制器
 *
 * @author lsc
 * @since 2019-03-26
 */
@RestController
@AllArgsConstructor
@RequestMapping("/admin/adminlogs")
@Api(value = "管理日志", tags = "管理日志")
public class AdminLogsController {

	private IAdminLogsService adminLogsService;



	/**
	* 详情
	*/
	@GetMapping("/detail")
	@ApiOperation(value = "详情", notes = "传入adminLogs", position = 1)
	public R<AdminLogs> detail(Long id) {
		AdminLogs detail = adminLogsService.findById(id);
		return R.data(detail);
	}

	/**
	* 分页 
	*/
	@GetMapping("/list")
	@ApiOperation(value = "分页", notes = "传入adminLogs", position = 2)
	public R<Page<AdminLogs>> list(Integer page, Integer size) {
		Page<AdminLogs> pages = adminLogsService.findPage(page,size);
		return R.data(pages);
	}


	/**
	* 新增或修改 
	*/
	@PostMapping("/submit")
	@ApiOperation(value = "新增或修改", notes = "传入adminLogs", position = 6)
	public R submit(@Valid @RequestBody AdminLogs adminLogs) {
		return R.status(adminLogsService.saveOrUpdate(adminLogs));
	}

	
	/**
	* 删除 
	*/
	@PostMapping("/remove")
	@ApiOperation(value = "删除", notes = "传入ids", position = 7)
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestBody Long[] ids) {
		return R.status(adminLogsService.deleteBatch(Arrays.asList(ids)));
	}
	
}
