package com.mtl.system.controller;

import com.mtl.common.oss.QiniuUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import com.mtl.common.tool.api.R;
import com.mtl.common.tool.model.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.mtl.system.domain.Iconfont;
import com.mtl.system.service.IIconfontService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Arrays;

/**
 *  控制器
 *
 * @author lsc
 * @since 2019-04-03
 */
@RestController
@RequestMapping("/admin/menu")
@Api(value = "", tags = "接口")
public class IconfontController {

	@Autowired
	private IIconfontService iconfontService;

	/**
	* 分页
	*/
	@GetMapping("/iconfont/page")
	@ApiOperation(value = "分页", notes = "传入iconfont", position = 2)
	public R<Page<Iconfont>> page(Integer page,Integer size) {
		Page<Iconfont> pages = iconfontService.findPage(page,size);
		return R.data(pages);
	}



}
