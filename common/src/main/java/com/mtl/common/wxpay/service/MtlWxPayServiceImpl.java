package com.mtl.common.wxpay.service;

import com.github.binarywang.wxpay.bean.notify.WxPayOrderNotifyResult;
import com.github.binarywang.wxpay.bean.request.BaseWxPayRequest;
import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import com.github.binarywang.wxpay.config.WxPayConfig;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.google.gson.Gson;
import com.mtl.common.tool.api.R;
import com.mtl.common.tool.jedis.JedisClient;
import com.mtl.common.tool.utils.IDUtil;
import com.mtl.common.tool.utils.IPUtils;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

@Service
public class MtlWxPayServiceImpl implements MtlWxPayService {

    @Autowired
    private com.github.binarywang.wxpay.service.WxPayService wxService;
    @Autowired
    private WxMpService mpService;
    @Autowired
    private JedisClient jedisClient;

    @Value("${server_domain}")
    private  String serverDomain;
    @Value("${wechat.pay.app-id}")
    private String appId;
    @Value("${wechat.mp.app-id}")
    private String mpAppId;


    public Object userAuth(String type) {
        String url = "http://" + serverDomain + "/api/wxpay/openId?type="+type;
        String s = mpService.oauth2buildAuthorizationUrl(url, WxConsts.OAuth2Scope.SNSAPI_BASE, null);
        return s;
    }

    public String getOpenId(String code, String type){
        try {
            WxMpOAuth2AccessToken accessToken = mpService.oauth2getAccessToken(code);
            String openId = accessToken.getOpenId();
           return "/wechat/index.html#/recharge?openId=" + openId+"&type="+type;
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 调用统一下单接口，并组装生成支付所需参数对象.
     *
     * @param openId 微信授权码 统一下单请求参数
     * @param <>   请使用{@link com.github.binarywang.wxpay.bean.order}包下的类
     * @return 返回 {@link com.github.binarywang.wxpay.bean.order}包下的类对象
     */
        public Object createOrder(String openId,String bodyname, String orderId, double price, HttpServletRequest request){
        Object result= null;
        try {
            WxPayUnifiedOrderRequest orderRequest = new WxPayUnifiedOrderRequest();
            orderRequest.setBody(bodyname);
            orderRequest.setOutTradeNo(orderId);
            Integer fee= BaseWxPayRequest.yuanToFen(price+"");//元转成分
            orderRequest.setTotalFee(fee);
            orderRequest.setOpenid(openId);
            orderRequest.setSpbillCreateIp(IPUtils.getIpAddr(request));
            String url = "http://" + serverDomain + "/api/wxpay/notify";
            orderRequest.setNotifyUrl(url);
            if(openId!=null) {
                orderRequest.setTradeType("JSAPI");//JSAPI公众号支付 MWEB为H5支付
            } else {
                orderRequest.setTradeType("MWEB");
            }
            result = wxService.createOrder(orderRequest);
        } catch (WxPayException e) {
            e.printStackTrace();
        }
        return  result;
    }


    public  Object charge(Map map, HttpServletRequest request){
        Object result= null;
        try {
            String money=(String) map.get("money");
            WxPayUnifiedOrderRequest orderRequest = new WxPayUnifiedOrderRequest();
            orderRequest.setBody("jpy");
            orderRequest.setOutTradeNo(IDUtil.getRandomId()+"");
            Integer fee=BaseWxPayRequest.yuanToFen(money);//元转成分
            orderRequest.setTotalFee(fee);
            orderRequest.setSpbillCreateIp(IPUtils.getIpAddr(request));
            String url = "http://" + serverDomain + "/api/order/notify";
            orderRequest.setNotifyUrl(url);
            orderRequest.setOpenid((String) map.get("openId"));
            orderRequest.setTradeType("JSAPI");
            WxPayConfig wcf=wxService.getConfig();
            System.out.println(map.get("openId"));
            System.out.println(wcf.getAppId());
            //wcf.setAppId(appId);
            wxService.setConfig(wcf);
            result = wxService.createOrder(orderRequest);
            jedisClient.set(orderRequest.getOutTradeNo(),new Gson().toJson(map.get("list")));
        } catch (WxPayException e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * 支付回调
     * @param xmlData
     * @throws WxPayException
     * @throws IOException
     */
    public WxPayOrderNotifyResult parseOrderNotifyResult(String xmlData){
        WxPayOrderNotifyResult wr=null;
        try {
            wr= this.wxService.parseOrderNotifyResult(xmlData);
        } catch (WxPayException e) {
            e.printStackTrace();
        }
        return wr;
    }
}
