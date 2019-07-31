package com.mtl.system.service.impl;

import com.mtl.system.domain.Settings;
import com.mtl.system.mapper.SettingsMapper;
import com.mtl.system.service.ISettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.mtl.common.tool.model.Page;

import java.util.List;
/**
 *  服务实现类
 *
 * @author lsc
 * @since 2019-03-26
 */
@Service
public class SettingsServiceImpl implements ISettingsService {

    @Autowired
    private SettingsMapper settingsMapper;

    @Override
    public Settings findById(Integer id) {
        return settingsMapper.selectByPrimaryKey(id);
    }

    @Override
    public Page<Settings> findPage(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        List<Settings> settingss=settingsMapper.selectAll();
        return new Page<>(settingss);
    }

    @Override
    public int saveOrUpdate(Settings settings) {
        if(settings.getId()!=null){
        return settingsMapper.updateByPrimaryKey(settings);
        }
        return settingsMapper.insert(settings);
    }

    @Override
    public int deleteBatch(List<Integer> ids) {
        return settingsMapper.deleteByIdList(ids);
    }
}
