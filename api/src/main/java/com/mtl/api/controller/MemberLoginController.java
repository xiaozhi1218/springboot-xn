package com.mtl.api.controller;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.mtl.common.tool.api.ResultCode;
import com.mtl.common.tool.utils.JwtUtil;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.mtl.common.tool.api.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.mtl.api.domain.Member;
import com.mtl.api.service.IMemberService;

import java.util.Date;
import java.util.Map;

/**
 * 会员管理 控制器
 *
 * @author lsc
 * @since 2019-05-05
 */
@RestController
@RequestMapping("/api")
@Api(value = "app会员管理", tags = "app会员管理接口")
public class MemberLoginController {

	@Autowired
	private IMemberService memberService;
	@Autowired
	private WxMaService wxMaService;
	/**
	 * 登录
	 */
	@PostMapping("/login")
	@ApiOperation(value = "登录", notes = "登录")
	public R<Member> detail(@RequestBody Map<String,Object> param) {
		try {
			Member detail = null;
			String code = (String) param.get("code");
			System.out.println(code);
			if (code != null) {
				WxMaJscode2SessionResult session = wxMaService.getUserService().getSessionInfo(code);
				String openId = session.getOpenid();
				System.out.println(openId);
				detail = memberService.findByOpenId(openId);
				if (detail == null) {
					detail = new Member();
					detail.setUserName((String) param.get("nickName"));
					detail.setNickname((String) param.get("nickName"));
					detail.setFace((String) param.get("avatarUrl"));
					detail.setRegtime(new Date());
					detail.setSex((Integer) param.get("gender"));
					detail.setOpenId(openId);
					memberService.insert(detail);
				}
			}
			// jwt
			String token = "Bearer " + Jwts.builder()
					//主题 放入用户名
					.setSubject(detail.getName())
					.claim("userId", detail.getMemberId())
					.claim("openId",detail.getOpenId())
					//失效时间
					.setExpiration(new Date(System.currentTimeMillis() + 12L*60*30*24*60 * 60 * 1000))
					//签名算法和密钥
					.signWith(SignatureAlgorithm.HS512, JwtUtil.generalKey("member"))
					.compact();
			detail.setToken(token);
			return R.data(detail);
		} catch (Exception e) {
			e.printStackTrace();
			return R.fail(ResultCode.UN_AUTHORIZED);
		}
	}

	/**
	 * 测试
	 */
	@PostMapping("/test")
	@ApiOperation(value = "登录", notes = "登录")
	public int test () {
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@");

return 1;
	}
}
