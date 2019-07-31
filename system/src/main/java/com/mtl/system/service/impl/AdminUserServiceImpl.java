package com.mtl.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.mtl.common.tool.model.Page;
import com.mtl.common.tool.utils.JwtUtil;
import com.mtl.system.domain.AdminUser;
import com.mtl.system.domain.vo.UserVo;
import com.mtl.system.mapper.AdminUserMapper;
import com.mtl.system.service.IAdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
/**
 * 平台用户 服务实现类
 *
 * @author lsc
 * @since 2019-03-27
 */
@Service
public class AdminUserServiceImpl implements IAdminUserService {

    @Autowired
    private AdminUserMapper adminuserMapper;

    @Override
    public AdminUser findById(Integer id) {
        return adminuserMapper.selectByPrimaryKey(id);
    }

    @Override
    public AdminUser findByUsername(String username) {
        return adminuserMapper.findByUsername(username);
    }

    @Override
    public Page<UserVo> findPage(Integer page, Integer size, String search) {
        PageHelper.startPage(page,size);
        List<UserVo> adminusers=adminuserMapper.selectByCondition(search);
        return new Page<>(adminusers);
    }

    @Override
    public int saveOrUpdate(AdminUser adminuser) {
        if(adminuser.getUserid()!=null){
        return adminuserMapper.updateByPrimaryKeySelective(adminuser);
        }
        adminuser.setCreateTime(new Date());
        adminuser.setCreator(JwtUtil.getUserId());
        return adminuserMapper.insert(adminuser);
    }

    @Override
    public int deleteBatch(List<Integer> ids) {
        for(int i=0;i<ids.size();i++){
            adminuserMapper.clearRegionAdmin(ids.get(i));
        }

        return adminuserMapper.deleteByIdList(ids);
    }

    /**
     * 查询该区域有无负责人，如果有，返回负责人
     */
    @Override
    public AdminUser findAdminFromRegions(Integer regionId) {
        return adminuserMapper.findAdminFromRegions(regionId);
    }

    /**
     * 修改区域负责人
     */
    @Override
    public int changeRegionAdmin(Integer regionId ,Integer userId) {
        if(userId==null){
            adminuserMapper.changeRegionAdmin(regionId,userId);
            return 1;//设置成功
        }
        else {
            adminuserMapper.changeRegionAdmin(regionId,userId);
            return 2;//修改成功
        }
    }

}
