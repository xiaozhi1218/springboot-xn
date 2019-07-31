package com.mtl.system.service.impl;


import com.github.pagehelper.PageHelper;
import com.mtl.common.tool.model.Page;
import com.mtl.system.domain.AdminLogs;
import com.mtl.system.mapper.AdminLogsMapper;
import com.mtl.system.service.IAdminLogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  服务实现类
 *
 * @author lsc
 * @since 2019-03-26
 */
@Service
public class AdminLogsServiceImpl implements IAdminLogsService {
    @Autowired
    private AdminLogsMapper adminLogsMapper;
    @Override
    public AdminLogs findById(Long id) {
        return adminLogsMapper.selectByPrimaryKey(id);
    }

    @Override
    public Page<AdminLogs> findPage(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        List<AdminLogs> menus=adminLogsMapper.selectAll();
        return new Page<>(menus);
    }

    @Override
    public int saveOrUpdate(AdminLogs adminLogs) {
        if(adminLogs.getLogId()!=null){
            return adminLogsMapper.updateByPrimaryKey(adminLogs);
        }
        return adminLogsMapper.insert(adminLogs);
    }

    @Override
    public int deleteBatch(List<Long> ids) {
        return adminLogsMapper.deleteByIdList(ids);
    }
}
