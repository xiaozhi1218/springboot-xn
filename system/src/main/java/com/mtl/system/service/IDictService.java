package com.mtl.system.service;

import com.mtl.system.domain.Dict;

import java.util.List;
/**
 *  服务类
 *
 * @author lsc
 * @since 2019-04-08
 */
public interface IDictService {

        Dict findById(Integer id);

        List<Dict> list();

        int saveOrUpdate(Dict dict);

        int deleteBatch(List<Integer> ids);
}
