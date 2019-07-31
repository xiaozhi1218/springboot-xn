package com.mtl.common.wxpay;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "wechat.pay")
public class WechatPayProperties {

	/**
	 * 公众号 APP_ID
	 */
	private String appId;
	/**
	 * 微信支付商户号
	 */
	private String mchId;

	/**
	 * 微信支付平台商户API密钥
	 */
	private String mchKey;
	/**
	 * 服务商模式下的子商户公众账号ID
	 */
	private String subAppId;
	/**
	 * 服务商模式下的子商户号
	 */
	private String subMchId;
	/**
	 * apiclient_cert.p12 证书文件的绝对路径
	 */
	private String keyPath;

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getMchId() {
		return mchId;
	}

	public void setMchId(String mchId) {
		this.mchId = mchId;
	}

	public String getMchKey() {
		return mchKey;
	}

	public void setMchKey(String mchKey) {
		this.mchKey = mchKey;
	}

	public String getSubAppId() {
		return subAppId;
	}

	public void setSubAppId(String subAppId) {
		this.subAppId = subAppId;
	}

	public String getSubMchId() {
		return subMchId;
	}

	public void setSubMchId(String subMchId) {
		this.subMchId = subMchId;
	}

	public String getKeyPath() {
		return keyPath;
	}

	public void setKeyPath(String keyPath) {
		this.keyPath = keyPath;
	}
	
	@Override
	  public String toString() {
	    return ToStringBuilder.reflectionToString(this,
	        ToStringStyle.MULTI_LINE_STYLE);
	  }

}
