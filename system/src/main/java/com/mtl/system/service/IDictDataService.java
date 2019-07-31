package com.mtl.system.service;

import com.mtl.system.domain.DictData;
import com.mtl.common.tool.model.Page;
import java.util.List;
/**
 *  服务类
 *
 * @author lsc
 * @since 2019-04-08
 */
public interface IDictDataService {

        DictData findById(Integer id);

        Page<DictData> findPage(Integer page,Integer size,Integer id);

        int saveOrUpdate(DictData dictData);

        int deleteBatch(List<Integer> ids);
}
