package com.mtl.system.controller;

import com.mtl.common.tool.utils.JwtUtil;
import com.mtl.system.domain.AdminUser;
import com.mtl.system.domain.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import com.mtl.common.tool.api.R;
import com.mtl.common.tool.model.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.mtl.system.service.IAdminUserService;

import java.util.Arrays;

/**
 * 平台用户 控制器
 *
 * @author lsc
 * @since 2019-03-27
 */
@RestController
@RequestMapping("/admin/adminuser")
@Api(value = "平台用户", tags = "平台用户接口")
public class AdminUserController {

	@Autowired
	private IAdminUserService adminuserService;

	@GetMapping("info")
	@ApiOperation(value = "获取当前用户信息", notes = "获取当前用户信息", position = 2)
	public R<AdminUser> info(){
		Integer id= JwtUtil.getUserId();
		return R.data(adminuserService.findById(id));
	}

	/**
	* 详情
	*/
	@GetMapping("/detail")
	@ApiOperation(value = "详情", notes = "传入adminuser", position = 1)
	public R<AdminUser> detail(Integer id) {
		AdminUser detail = adminuserService.findById(id);
		return R.data(detail);
	}


	/**
	* 分页 平台用户
	*/
	@GetMapping("/page")
	@ApiOperation(value = "分页", notes = "传入adminuser", position = 2)
	public R<Page<UserVo>> page(Integer page,Integer size,String search) {
		Page<UserVo> pages = adminuserService.findPage(page,size,search);
		return R.data(pages);
	}

	/**
	* 新增或修改 平台用户
	*/
	@PostMapping("/save")
	@ApiOperation(value = "新增或修改", notes = "传入adminuser", position = 6)
	public R submit(@RequestBody AdminUser adminuser) {

		return R.status(adminuserService.saveOrUpdate(adminuser));
	}

	/**
	* 删除 平台用户
	*/
	@PostMapping("/remove")
	@ApiOperation(value = "删除", notes = "传入ids", position = 7)
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestBody Integer[] ids) {
		return R.status(adminuserService.deleteBatch(Arrays.asList(ids)));
	}

	/**
	 * 查询该区域有无负责人，如果有，返回负责人
	 */
	@GetMapping("/findAdminFromRegions")
	@ApiOperation(value = "查询该区域有无负责人", notes = "传入adminuser", position = 2)
	public R findAdminFromRegions(Integer regionId) {

		return R.data(adminuserService.findAdminFromRegions(regionId));
	}

	/**
	 * 修改区域负责人
	 */
	@GetMapping ("/changeRegionAdmin")
	@ApiOperation(value = "查询该区域有无负责人", notes = "传入adminuser", position = 2)
	public R changeRegionAdmin(Integer regionId ,Integer userId) {
		Integer state=adminuserService.changeRegionAdmin(regionId,userId);
		if(state==1){
			return R.success("设置成功");
		}
		else if(state==2){
			return R.success("修改成功");
		}
		else {
            return R.fail("修改失败");
        }
	}


}
