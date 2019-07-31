package com.mtl.member.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import com.mtl.common.tool.api.R;
import com.mtl.common.tool.model.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.mtl.member.domain.Member;
import com.mtl.member.service.IMemberService;
import java.util.List;
import java.util.Arrays;

/**
 * 会员管理 控制器
 *
 * @author lsc
 * @since 2019-07-31
 */
@RestController
@RequestMapping("/admin/member")
@Api(value = "会员管理", tags = "会员管理接口")
public class MemberController {
    @Autowired
	private IMemberService memberService;

	/**
	* 详情
	*/
	@GetMapping("/detail")
	@ApiOperation(value = "详情", notes = "传入member", position = 1)
	public R<Member> detail(Integer id) {
		Member detail = memberService.findById(id);
		return R.data(detail);
	}

	/**
	* 分页 会员管理
	*/
	@GetMapping("/page")
	@ApiOperation(value = "分页", notes = "传入member", position = 2)
	public R<Page<Member>> page(Integer page,Integer size) {
		Page<Member> pages = memberService.findPage(page,size);
		return R.data(pages);
	}

	/**
	* 新增或修改 会员管理
	*/
	@PostMapping("/submit")
	@ApiOperation(value = "新增或修改", notes = "传入member", position = 6)
	public R submit(@RequestBody Member member) {
		return R.status(memberService.saveOrUpdate(member));
	}

	/**
	* 删除 会员管理
	*/
	@PostMapping("/remove")
	@ApiOperation(value = "删除", notes = "传入ids", position = 7)
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestBody Integer[] ids) {
		return R.status(memberService.deleteBatch(Arrays.asList(ids)));
	}

}
