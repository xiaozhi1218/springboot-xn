package com.mtl.member.mapper;

import com.mtl.member.domain.Member;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.additional.idlist.IdListMapper;
import tk.mybatis.mapper.common.BaseMapper;
import java.util.List;

/**
 * 会员管理 Mapper 接口
 *
 * @author lsc
 * @since 2019-07-31
 */
@Repository
public interface MemberMapper  extends BaseMapper<Member>, IdListMapper<Member,Integer>{
}
