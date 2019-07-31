package com.mtl.system.service;


import com.mtl.common.tool.model.Page;
import com.mtl.system.domain.AdminLogs;
import com.mtl.system.domain.Menu;

import java.util.List;

/**
 *  服务类
 *
 * @author lsc
 * @since 2019-03-26
 */
public interface IAdminLogsService {
    AdminLogs findById(Long id);

    Page<AdminLogs> findPage(Integer page, Integer size);

    int saveOrUpdate(AdminLogs adminLogs);

    int deleteBatch(List<Long> ids);

}
