package com.mtl.api.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MemberFilterConfig {

    @Bean
    public MemberLoginFilter memberLoginFilter(){
        return  new MemberLoginFilter();
    }

    @Bean
    public FilterRegistrationBean registFilter2(MemberLoginFilter memberLoginFilter) {
        FilterRegistrationBean registration2 = new FilterRegistrationBean();
        registration2.setFilter(memberLoginFilter);
        registration2.addUrlPatterns("/api/member/*");//过滤路径
        registration2.addInitParameter("exclusions", "/api/member/login");//除去路径不过滤
        registration2.setName("MemberLoginFilter");
        registration2.setOrder(1);
        return registration2;
    }
}