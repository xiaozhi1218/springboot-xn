package com.mtl.system.service;

import com.mtl.common.tool.model.Page;

import com.mtl.system.domain.Role;

import java.util.List;

public interface RoleService {

    Role findById(Integer id);

    Page<Role> findPage(Integer page, Integer size);

    int saveOrUpdate(Role role);

    int deleteBatch(List<Integer> ids);


}
