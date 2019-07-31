package com.mtl.system.service;

import com.mtl.system.domain.Settings;
import com.mtl.common.tool.model.Page;
import java.util.List;
/**
 *  服务类
 *
 * @author lsc
 * @since 2019-03-26
 */
public interface ISettingsService {

        Settings findById(Integer id);

        Page<Settings> findPage(Integer page,Integer size);

        int saveOrUpdate(Settings settings);

        int deleteBatch(List<Integer> ids);
}
