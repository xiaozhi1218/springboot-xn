package com.mtl.common.tool.utils;

import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;

public class JwtUtil {

    private JwtUtil() { }

    public static Integer getUserId(){
        HttpServletRequest request = WebUtil.getRequest();
        Integer userId= (Integer) request.getAttribute("userId");
        return userId;
    }

    public static String getOpenId(){
        HttpServletRequest request = WebUtil.getRequest();
        return (String) request.getAttribute("openId");
    }

    /**
     * 由字符串生成加密key
     *
     * @return
     */
    public static SecretKey generalKey(String stringKey) {

        // 本地的密码解码
        byte[] encodedKey = Base64.decodeBase64(stringKey);

        // 根据给定的字节数组使用AES加密算法构造一个密钥
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");

        return key;
    }
}
