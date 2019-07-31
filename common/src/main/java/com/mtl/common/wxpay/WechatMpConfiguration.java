package com.mtl.common.wxpay;

import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(WxMpService.class)
@EnableConfigurationProperties(WechatMpProperties.class)
public class WechatMpConfiguration {
    @Autowired
    private  WechatMpProperties mpProperties;

    @Bean
    @ConditionalOnMissingBean
    public WxMpService wxMpService(){
        WxMpInMemoryConfigStorage mpInMemoryConfigStorage=new WxMpInMemoryConfigStorage();
        mpInMemoryConfigStorage.setAppId(StringUtils.trimToNull(this.mpProperties.getAppId()));
        mpInMemoryConfigStorage.setSecret(StringUtils.trimToNull(this.mpProperties.getSecret()));
        mpInMemoryConfigStorage.setAesKey(StringUtils.trimToNull(this.mpProperties.getAesKey()));
        mpInMemoryConfigStorage.setAccessToken(StringUtils.trimToNull(this.mpProperties.getToken()));
        WxMpService mpService=new WxMpServiceImpl();
        mpService.setWxMpConfigStorage(mpInMemoryConfigStorage);
        return mpService;
    }
}
