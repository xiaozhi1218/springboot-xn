package com.mtl.api.service.impl;

import com.mtl.api.domain.*;
import com.mtl.api.mapper.*;
import com.mtl.api.service.IMemberService;
import com.mtl.common.tool.utils.DigestUtil;
import com.mtl.common.tool.utils.JwtUtil;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 会员管理 服务实现类
 *
 * @author lsc
 * @since 2019-05-05
 */
@Service
public class MemberLoginServiceImpl implements IMemberService {

    @Autowired
    private MemberLoginMapper memberLoginMapper;


    @Override
    public Member login(String phone, String password) {
        Member member= memberLoginMapper.login(phone, DigestUtil.md5Hex(password));
        // jwt
        String token = "Bearer " + Jwts.builder()
                //主题 放入用户名
                .setSubject(member.getName())
                .claim("userId", member.getMemberId())
                //失效时间
                .setExpiration(new Date(System.currentTimeMillis() + 30L*24*60 * 60 * 1000))
                //签名算法和密钥
                .signWith(SignatureAlgorithm.HS512, JwtUtil.generalKey("member"))
                .compact();
        member.setToken(token);
        System.out.println("token====>"+member.getToken());
        return member;
    }

    @Override
    public Member findById(Integer userId) {
        Member merchant= memberLoginMapper.findById(userId);
        System.out.println("查询用户======》"+userId);

        return merchant;
    }
    @Override
    public Member findByOpenId(String openId) {
        return memberLoginMapper.findByOpenId(openId);
    }

    @Override
    public Integer insert(Member member) {
        return memberLoginMapper.insertSelective(member);
    }
}
