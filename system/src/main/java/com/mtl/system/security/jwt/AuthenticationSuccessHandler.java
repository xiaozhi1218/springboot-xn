package com.mtl.system.security.jwt;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.mtl.common.tool.api.R;
import com.mtl.common.tool.utils.JwtUtil;
import com.mtl.common.tool.utils.ResponseUtil;
import com.mtl.system.security.SecurityUserDetails;
import com.mtl.system.security.constant.SecurityConstant;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 登录成功处理类
 *
 * @author lsc
 */
@Slf4j
@Component
public class AuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Value("${mtl.tokenExpireTime}")
    private Integer tokenExpireTime;

    @Value("${mtl.saveLoginTime}")
    private Integer saveLoginTime;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        SecurityUserDetails user = (SecurityUserDetails) authentication.getPrincipal();
        List<GrantedAuthority> authorities = (List<GrantedAuthority>) ((UserDetails) authentication.getPrincipal()).getAuthorities();
        System.out.println(authentication);
        List<String> list = new ArrayList<>();
        for (GrantedAuthority g : authorities) {
            list.add(g.getAuthority());
        }
        // 登陆成功生成token
        String token = "";
        ObjectMapper mapper = new ObjectMapper();
        // jwt
        token = SecurityConstant.TOKEN_SPLIT + Jwts.builder()
                //主题 放入用户名
                .setSubject(user.getUsername())
                .claim("userId", user.getUserid())
                //自定义属性 放入用户拥有请求权限
                .claim(SecurityConstant.AUTHORITIES, mapper.writeValueAsString(list))
                //失效时间
                .setExpiration(new Date(System.currentTimeMillis() + tokenExpireTime * 60 * 1000))
                //签名算法和密钥
                .signWith(SignatureAlgorithm.HS512, JwtUtil.generalKey(SecurityConstant.JWT_SIGN_KEY))
                .compact();

        ResponseUtil.out(response, R.data(200, token, "登录成功"));
    }
}
