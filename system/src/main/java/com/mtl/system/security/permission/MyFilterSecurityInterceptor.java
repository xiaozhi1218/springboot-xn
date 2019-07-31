package com.mtl.system.security.permission;

import com.mtl.common.tool.utils.StringUtil;
import com.mtl.system.security.config.IgnoredUrlsProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 权限管理过滤器
 * 监控用户行为
 * @author Exrickx
 */
@Slf4j
@Component
public class MyFilterSecurityInterceptor extends AbstractSecurityInterceptor implements Filter {

    @Autowired
    private FilterInvocationSecurityMetadataSource securityMetadataSource;
    @Autowired
    private IgnoredUrlsProperties ignoredUrlsProperties;

    @Autowired
    public void setMyAccessDecisionManager(MyAccessDecisionManager myAccessDecisionManager) {
        super.setAccessDecisionManager(myAccessDecisionManager);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.setRejectPublicInvocations(true);
    }
    /*
     * 判断是否被忽略拦截
     * */
    private boolean canIgnore(HttpServletRequest request) {
        PathMatcher matcher=new AntPathMatcher();
        for (String page : ignoredUrlsProperties.getUrls()) {// 判断是否在过滤url之外
            if (matcher.match(page.trim(),(request).getServletPath())) {
               return true;
            }
        }
        return false;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request1= (HttpServletRequest) request;
        if (canIgnore(request1)) {
            chain.doFilter(request, response);
            return;
        }
        FilterInvocation fi = new FilterInvocation(request, response, chain);
        invoke(fi);
    }

    public void invoke(FilterInvocation fi) throws IOException, ServletException {

        InterceptorStatusToken token = null;
        try {
            token = super.beforeInvocation(fi);
        } catch (Exception e) {
           throw  new AccessDeniedException("抱歉，您没有访问权限");
        }
        try {
            fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
        }  finally {
            super.afterInvocation(token, null);
        }
    }

    @Override
    public void destroy() {

    }

    @Override
    public Class<?> getSecureObjectClass() {
        return FilterInvocation.class;
    }

    @Override
    public SecurityMetadataSource obtainSecurityMetadataSource() {
        return this.securityMetadataSource;
    }
}

