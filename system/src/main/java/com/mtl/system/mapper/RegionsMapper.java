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

import com.mtl.system.domain.Regions;
import com.mtl.system.domain.vo.RegionsVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.additional.idlist.IdListMapper;
import tk.mybatis.mapper.common.BaseMapper;
import java.util.List;

/**
 *  Mapper 接口
 *
 * @author lsc
 * @since 2019-04-14
 */
@Repository
public interface RegionsMapper  extends BaseMapper<Regions>, IdListMapper<Regions,Integer>{
    //获取初级菜单
    List<RegionsVO> regions(@Param("ids") Integer[]  ids);

    //获取细节菜单
    List<Regions> regionsList(@Param("ids") Integer  ids);

    /*找出该用户的区域*/
    Integer[] authRegionsIds(@Param("id")Integer id);

    int findByParentId(Integer id);
    /*修改节点*/
    int updateRegionsVO(@Param("regionsVO")Regions regions);
    /*新增节点*/
    int insertRegionsVO(@Param("regionsVO")Regions regions);
    /*获取单个区域*/
    Regions selectRegions(@Param("id")Integer id);

    /*查找区域下有无对应用户*/
    int selectUserInRegion(@Param("id")Integer id);

    /*查找区域下有无对应角色*/
    int selectRoleInRegion(@Param("id")Integer id);

    /*删除区域*/
    int deleteRegionsVO(@Param("id")Integer id);

}
