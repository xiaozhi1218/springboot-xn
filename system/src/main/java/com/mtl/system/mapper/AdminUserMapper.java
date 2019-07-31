/**
 * Copyright (c) 2018-2028, Chill Zhuang 庄骞 (smallchill@163.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mtl.system.mapper;

import com.mtl.system.domain.AdminUser;
import com.mtl.system.domain.vo.UserVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.additional.idlist.IdListMapper;
import tk.mybatis.mapper.common.BaseMapper;
import java.util.List;

/**
 * 平台用户 Mapper 接口
 *
 * @author lsc
 * @since 2019-03-27
 */
@Repository
public interface AdminUserMapper  extends BaseMapper<AdminUser>, IdListMapper<AdminUser,Integer>{

    AdminUser adminLogin(@Param("username") String userName, @Param("password") String password);

    AdminUser findByUsername(@Param("username") String username);

    List<UserVo> selectByCondition(@Param("searchKey") String searchKey);

    /**
     * 查询该区域有无负责人，如果有，返回负责人
     */
    AdminUser findAdminFromRegions(@Param("regionId")Integer regionId);

    /**
     * 通过用户ID查询用户名称
     */
    String  selectnameById(@Param("id")Integer id);

    /**
     * 修改区域负责人
     */
    int changeRegionAdmin(@Param("regionId")Integer regionId ,@Param("userId")Integer userId);

    /*
    * 清空该用户的区域负责人
    * */
    int clearRegionAdmin(@Param("userId")Integer userId);
}
