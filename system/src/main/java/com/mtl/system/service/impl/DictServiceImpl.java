package com.mtl.system.service.impl;

import com.mtl.system.domain.Dict;
import com.mtl.system.mapper.DictMapper;
import com.mtl.system.service.IDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.mtl.common.tool.model.Page;

import java.util.List;
/**
 *  服务实现类
 *
 * @author lsc
 * @since 2019-04-08
 */
@Service
public class DictServiceImpl implements IDictService {

    @Autowired
    private DictMapper dictMapper;

    @Override
    public Dict findById(Integer id) {
        return dictMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Dict> list() {
        List<Dict> dicts=dictMapper.selectAll();
        return dicts;
    }

    @Override
    public int saveOrUpdate(Dict dict) {
        if(dict.getId()!=null){
        return dictMapper.updateByPrimaryKey(dict);
        }
        return dictMapper.insert(dict);
    }

    @Override
    public int deleteBatch(List<Integer> ids) {
        return dictMapper.deleteByIdList(ids);
    }
}
