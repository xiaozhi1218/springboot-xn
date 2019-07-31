package com.mtl.api.mapper;

import com.mtl.api.domain.Member;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.additional.idlist.IdListMapper;
import tk.mybatis.mapper.common.BaseMapper;

/**
 * 会员管理 Mapper 接口
 *
 * @author lsc
 * @since 2019-05-05
 */
@Repository
public interface MemberLoginMapper extends BaseMapper<Member>, IdListMapper<Member,Integer>{

    Member login(@Param("phone") String phone, @Param("password") String password);

    Member findById(@Param("id") Integer id);

    Member findByOpenId(@Param("openId") String openId);
}
