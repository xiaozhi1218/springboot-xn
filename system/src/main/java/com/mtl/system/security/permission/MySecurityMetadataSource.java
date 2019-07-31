package com.mtl.system.security.permission;

import com.mtl.common.tool.utils.JwtUtil;
import com.mtl.common.tool.utils.StringUtil;
import com.mtl.system.domain.Menu;
import com.mtl.system.domain.Role;
import com.mtl.system.service.IMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import java.util.*;

/**
 * 权限资源管理器
 * 为权限决断器提供支持
 * @author Exrickx
 */
@Slf4j
@Component
public class MySecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    private FilterInvocationSecurityMetadataSource  superMetadataSource;
    @Autowired
    private IMenuService permissionService;

    private Map<String, Collection<ConfigAttribute>> map = null;
    private  List<String> permissions;
    /**
     * 加载权限表中所有操作请求权限
     */
    public void loadResourceDefine(){
        map = new HashMap<String, Collection<ConfigAttribute>>(16);
        Collection<ConfigAttribute> configAttributes;
        ConfigAttribute cfg;
        // 获取启用的权限操作请求
//        List<Menu> permissions = permissionService.authMenu(JwtUtil.getUserId());
//        for(Menu permission : permissions) {
//            if(StringUtil.isNotBlank(permission.getTitle())&&StringUtil.isNotBlank(permission.getUrl())){
//                configAttributes = new ArrayList<>();
//                cfg = new SecurityConfig(permission.getTitle());
//                //作为MyAccessDecisionManager类的decide的第三个参数
//                configAttributes.add(cfg);
//                //用权限的path作为map的key，用ConfigAttribute的集合作为value
//                map.put(permission.getUrl(), configAttributes);
//            }
//        }
         Role role=permissionService.getAuthUrlByUserId(JwtUtil.getUserId());
         permissions=Arrays.asList(role.getAuthUrl().split(","));
         for (String p:permissions){
               configAttributes = new ArrayList<>();
                cfg = new SecurityConfig(role.getRoleName());
//                //作为MyAccessDecisionManager类的decide的第三个参数
                configAttributes.add(cfg);
//                //用权限的path作为map的key，用ConfigAttribute的集合作为value
                map.put(p, configAttributes);
         }
    }

    /**
     * 判定用户请求的url是否在权限表中
     * 如果在权限表中，则返回给decide方法，用来判定用户是否有此权限
     * 如果不在权限表中则放行
     * @param o
     * @return
     * @throws IllegalArgumentException
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        if(permissions == null){
            loadResourceDefine();
        }
        //Object中包含用户请求request

        String url = ((FilterInvocation) o).getRequestUrl();
        for (String p:permissions){
            if (StringUtil.isNotBlank(p)&&url.startsWith(p)) {
                return map.get(p);
            }
        }
//        PathMatcher pathMatcher = new AntPathMatcher();
//        Iterator<String> iterator = map.keySet().iterator();
//        while (iterator.hasNext()) {
//            String resURL = iterator.next();
//            if (StringUtil.isNotBlank(resURL)&&pathMatcher.match(resURL,url)) {
//                return map.get(resURL);
//            }
//        }
        return null;
//        Collection<ConfigAttribute> returnCollection = new ArrayList<ConfigAttribute>();
//        returnCollection.add(new SecurityConfig("ROLE_NO_USER"));
//        return returnCollection;
    }


    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
