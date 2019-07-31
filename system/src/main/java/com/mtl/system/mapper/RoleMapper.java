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

import com.mtl.system.domain.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.additional.idlist.IdListMapper;
import tk.mybatis.mapper.common.BaseMapper;
import java.util.List;

/**
 * 角色表 Mapper 接口
 *
 * @author lsc
 * @since 2019-04-14
 */
@Repository
public interface RoleMapper  extends BaseMapper<Role>, IdListMapper<Role,Integer>{
    List<Role> selectByCondition(@Param("searchKey") String searchKey);

    /*
    查找角色有没有关联的用户
    * */
    Integer selectAdminByRole(@Param("roleId") Integer roleId);

    Role selectAuthUrls(@Param("id") Integer id);
}
