package com.mtl.system.security;

import com.mtl.common.exception.LoginFailLimitException;
import com.mtl.common.tool.utils.StringUtil;
import com.mtl.system.domain.AdminUser;
import com.mtl.system.service.IAdminUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author Exrickx
 */
@Slf4j
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private IAdminUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String flagKey = "loginFailFlag:"+username;
        String value = redisTemplate.opsForValue().get(flagKey);
        Long timeRest = redisTemplate.getExpire(flagKey, TimeUnit.MINUTES);
        if(StringUtil.isNotBlank(value)){
            //超过限制次数
            throw new LoginFailLimitException("登录错误次数超过限制，请"+timeRest+"分钟后再试");
        }
        AdminUser user = userService.findByUsername(username);
        System.out.println(user);
        if(user==null){
          throw new UsernameNotFoundException("用户不存在");
        }
        return new SecurityUserDetails(user);
    }
}
