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
package com.mtl.system.service;

import com.mtl.system.domain.Role;
import com.mtl.common.tool.model.Page;
import java.util.List;
/**
 * 角色表 服务类
 *
 * @author lsc
 * @since 2019-04-14
 */
public interface IRoleService {

        Role findById(Integer id);

        Page<Role> findPage(Integer page,Integer size,String search);

        int saveOrUpdate(Role role);

        int deleteBatch(List<Integer> ids);
}
