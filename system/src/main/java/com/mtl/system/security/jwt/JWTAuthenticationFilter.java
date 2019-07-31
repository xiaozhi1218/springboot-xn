package com.mtl.system.security.jwt;

import com.alibaba.fastjson.JSONArray;
import com.mtl.common.tool.api.R;
import com.mtl.common.tool.api.ResultCode;
import com.mtl.common.tool.utils.JwtUtil;
import com.mtl.common.tool.utils.ResponseUtil;
import com.mtl.common.tool.utils.StringUtil;
import com.mtl.system.security.constant.SecurityConstant;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lsc
 */
@Slf4j
public class JWTAuthenticationFilter extends BasicAuthenticationFilter {


    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager, AuthenticationEntryPoint authenticationEntryPoint) {
        super(authenticationManager, authenticationEntryPoint);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader(SecurityConstant.HEADER);
        if (StringUtil.isBlank(header)) {
            header = request.getParameter(SecurityConstant.HEADER);
        }
        if(StringUtil.isBlank(header)){
            chain.doFilter(request, response);
            return;
        }
        // 权限
        List<GrantedAuthority> authorities = new ArrayList<>();
        List<String> list=new ArrayList<>();

        try {
            // 解析token
            Claims claims = Jwts.parser()
                    .setSigningKey(JwtUtil.generalKey(SecurityConstant.JWT_SIGN_KEY))
                    .parseClaimsJws(header.replace(SecurityConstant.TOKEN_SPLIT, ""))
                    .getBody();
            String username=claims.getSubject();
            Integer userId= (Integer) claims.get("userId");
            list=JSONArray.parseArray((String)claims.get(SecurityConstant.AUTHORITIES)).toJavaList(String.class);
               list.forEach(auth->{
                   authorities.add(new SimpleGrantedAuthority(auth));
               });
            System.out.println(list);
            if (StringUtil.isNotBlank(username)) {
                //踩坑提醒 此处password不能为null
                User principal = new User(username, "", authorities);
                Authentication authentication= new UsernamePasswordAuthenticationToken(principal, null, authorities);
                SecurityContextHolder.getContext().setAuthentication(authentication);
                request.setAttribute("userId",userId);
                chain.doFilter(request, response);
            }
            else {
                System.out.println("********()");
                ResponseUtil.out(response, R.fail(ResultCode.UN_AUTHORIZED));
                return;

            }

        } catch (Exception e) {
            e.printStackTrace();
            ResponseUtil.out(response, R.fail(ResultCode.INTERNAL_SERVER_ERROR));
        }
    }

}

