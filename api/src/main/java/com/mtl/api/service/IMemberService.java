package com.mtl.api.service;

import com.mtl.api.domain.Member;

/**
 * 会员管理 服务类
 *
 * @author lsc
 * @since 2019-05-05
 */
public interface IMemberService {

        Member login(String phone,String password);

        Member findById(Integer userId);

        Member findByOpenId(String openId);

        Integer insert(Member member);
}
