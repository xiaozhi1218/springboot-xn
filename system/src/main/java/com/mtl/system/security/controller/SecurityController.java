package com.mtl.system.security.controller;

import com.mtl.common.tool.api.R;
import com.mtl.common.tool.api.ResultCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lsc
 */
@Slf4j
@RestController
@Api(description = "Security相关接口")
@RequestMapping("/admin")
@Transactional
public class SecurityController {

    @CrossOrigin
    @RequestMapping(value = "/needLogin",method = RequestMethod.GET)
    @ApiOperation(value = "没有登录")
    public R<Object> needLogin(){
        return R.fail(ResultCode.UN_AUTHORIZED);
    }
}
