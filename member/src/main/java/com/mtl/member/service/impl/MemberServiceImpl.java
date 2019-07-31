package com.mtl.member.service.impl;

import com.mtl.member.domain.Member;
import com.mtl.member.mapper.MemberMapper;
import com.mtl.member.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.mtl.common.tool.model.Page;

import java.util.List;
/**
 * 会员管理 服务实现类
 *
 * @author lsc
 * @since 2019-07-31
 */
@Service
public class MemberServiceImpl implements IMemberService {

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public Member findById(Integer id) {
        return memberMapper.selectByPrimaryKey(id);
    }

    @Override
    public Page<Member> findPage(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        List<Member> members=memberMapper.selectAll();
        return new Page<>(members);
    }

    @Override
    public int saveOrUpdate(Member member) {
        if(member.getMemberId()!=null){
        return memberMapper.updateByPrimaryKey(member);
        }
        return memberMapper.insert(member);
    }

    @Override
    public int deleteBatch(List<Integer> ids) {
        return memberMapper.deleteByIdList(ids);
    }
}
