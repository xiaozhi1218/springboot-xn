package com.mtl.system.service.impl;

import com.mtl.system.domain.Role;
import com.mtl.system.mapper.RoleMapper;
import com.mtl.system.security.permission.MySecurityMetadataSource;
import com.mtl.system.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.mtl.common.tool.model.Page;

import java.util.List;
/**
 * 角色表 服务实现类
 *
 * @author lsc
 * @since 2019-04-14
 */
@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private MySecurityMetadataSource securityMetadataSource;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Role findById(Integer id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public Page<Role> findPage(Integer page, Integer size,String search) {
        PageHelper.startPage(page,size);

        List<Role> roles=roleMapper.selectByCondition(search);
        return new Page<>(roles);
    }

    @Override
    public int saveOrUpdate(Role role) {
        int result=0;
        if(role.getRoleId()!=null){
        result= roleMapper.updateByPrimaryKey(role);
            securityMetadataSource.loadResourceDefine();
        return result;
        }
         result=roleMapper.insert(role);
        return  result;
    }

    @Override
    public int deleteBatch(List<Integer> ids) {
        for(int i=0;i<ids.size();i++){
           if(roleMapper.selectAdminByRole(ids.get(i))>0) {
               ids.remove(i);//////////////////////////////////////////////////////////////////
           }
        }
        if (ids.size()>0){
            return roleMapper.deleteByIdList(ids);
        }
        else{
            return 0;
        }

    }
}
