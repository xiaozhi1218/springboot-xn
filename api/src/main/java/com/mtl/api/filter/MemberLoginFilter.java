package com.mtl.api.filter;

import com.mtl.api.domain.Member;
import com.mtl.api.service.IMemberService;
import com.mtl.common.tool.api.R;
import com.mtl.common.tool.api.ResultCode;
import com.mtl.common.tool.utils.JwtUtil;
import com.mtl.common.tool.utils.ResponseUtil;
import com.mtl.common.tool.utils.StringUtil;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.FilterConfig;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class MemberLoginFilter implements Filter {

    @Autowired
    private IMemberService memberService;
    /*
    * filterConfig中定义的非拦截字符串
    * */
    private String ignoresParam;
    /*
    * 用于存放不拦截的地址的数组
    * */
    private String[] prefixIignores ;

    /*
    * 初始化过滤器
    * */
    @Override
    public void init(FilterConfig memberFilterConfig) throws ServletException {
        ignoresParam = memberFilterConfig.getInitParameter("exclusions");
        if (!StringUtil.isBlank(ignoresParam)) {//如果非拦截字符串不为空
            prefixIignores = ignoresParam.split(",");//分解成一个一个的字符串（这里是地址）放入prefixIignores
        }
        return;//直接返回，不过滤
    }

    /*
     * 判断是否被忽略拦截
     * */
    private boolean canIgnore(HttpServletRequest request) {
        boolean isExcludedPage = false;
        System.out.println("进入到过滤器判断"+request);
        for (String page : prefixIignores) {// 判断是否在过滤url之外
            if ((request).getServletPath().equals(page)) {
                isExcludedPage = true;
                System.out.println("过滤器判断忽略");
                break;
            }
        }
        return isExcludedPage;
    }



    /*
    * 过滤器
    * */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;
        if (canIgnore(request)) {
            filterChain.doFilter(request, response);
            return;
        }
        String token=request.getHeader("member_auth");
        if(token==null){
            token= (String) request.getAttribute("token");
        }
        if(StringUtil.isBlank(token)){
            ResponseUtil.out(response, R.fail(ResultCode.UN_AUTHORIZED));
            return;
        }
        // 解析token

        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(JwtUtil.generalKey("member"))//
                    .parseClaimsJws(token.replace("Bearer ", ""))
                    .getBody();
            String username=claims.getSubject();//////
            Integer userId= (Integer) claims.get("userId");/////
            Member member  =memberService.findById(userId);


            //验证该用户是否存在
            if (member!=null) {
                 request.setAttribute("userId",userId);
                 request.setAttribute("openId",member.getOpenId());
                 filterChain.doFilter(request, response);
             }
             else {
                 ResponseUtil.out(response, R.fail(ResultCode.UN_AUTHORIZED));
                 return;
             }
        } catch (ExpiredJwtException e) {
            ResponseUtil.out(response, R.fail(ResultCode.UN_AUTHORIZED));
        }  catch (Exception e) {
            ResponseUtil.out(response, R.fail(ResultCode.INTERNAL_SERVER_ERROR));
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {

    }
}
