package com.mtl.common.wxpay.service;

import com.github.binarywang.wxpay.bean.notify.WxPayOrderNotifyResult;
import com.mtl.common.tool.api.R;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public interface MtlWxPayService {
    Object userAuth(String type);
    String getOpenId(String code, String type);
    Object createOrder(String openId,String bodyname, String orderId, double price, HttpServletRequest request);

    Object charge(Map map, HttpServletRequest request);

    WxPayOrderNotifyResult parseOrderNotifyResult(String xmlData);
}
