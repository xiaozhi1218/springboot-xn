package com.mtl.common.oss;

import com.qiniu.util.Auth;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 云存储配置信息
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-25 16:12
 */
@Component
@ConfigurationProperties(prefix = "qiniu")
public class CloudStorageConfig implements Serializable {
    private static final long serialVersionUID = 1L;
    //七牛绑定的域名
    private static String cdnPrefix;
    //七牛ACCESS_KEY

    private static String accessKey;
    //七牛SECRET_KEY

    private static String secretKey;
    //七牛存储空间名
    private static String bucket;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static String getCdnPrefix() {
        return cdnPrefix;
    }
    @Value("cdnPrefix")
    public void setCdnPrefix(String cdnPrefix) {
        this.cdnPrefix = cdnPrefix;
    }

    public static String getAccessKey() {
        return accessKey;
    }
    @Value("accessKey")
    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public static  String getSecretKey() {
        return secretKey;
    }
    @Value("secretKey")
    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public static String getBucket() {
        return bucket;
    }
    @Value("bucket")
    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public static Auth createAuth(){
        return Auth.create(accessKey, secretKey);
    }
}
