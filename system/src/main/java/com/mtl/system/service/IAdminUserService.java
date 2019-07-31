package com.mtl.system.service;

import com.mtl.system.domain.AdminUser;
import com.mtl.common.tool.model.Page;
import com.mtl.system.domain.vo.UserVo;

import java.util.List;
/**
 * 平台用户 服务类
 *
 * @author lsc
 * @since 2019-03-27
 */
public interface IAdminUserService {

        AdminUser findById(Integer id);

        AdminUser findByUsername(String username);

        Page<UserVo> findPage(Integer page, Integer size, String search);

        int saveOrUpdate(AdminUser adminuser);

        int deleteBatch(List<Integer> ids);

        /**
         * 查询该区域有无负责人，如果有，返回负责人
         */
        AdminUser findAdminFromRegions(Integer regionId);

        /**
         * 修改区域负责人
         */
        int changeRegionAdmin(Integer regionId ,Integer userId);


}
