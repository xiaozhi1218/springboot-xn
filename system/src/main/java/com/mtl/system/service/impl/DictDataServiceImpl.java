package com.mtl.system.service.impl;

import com.mtl.system.domain.DictData;
import com.mtl.system.mapper.DictDataMapper;
import com.mtl.system.service.IDictDataService;
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
public class DictDataServiceImpl implements IDictDataService {

    @Autowired
    private DictDataMapper dictDataMapper;

    @Override
    public DictData findById(Integer id) {
        return dictDataMapper.selectByPrimaryKey(id);
    }

    @Override
    public Page<DictData> findPage(Integer page, Integer size,Integer id) {
        PageHelper.startPage(page,size);
        List<DictData> dictDatas=dictDataMapper.findByDictId(id);
        return new Page<>(dictDatas);
    }

    @Override
    public int saveOrUpdate(DictData dictData) {
        if(dictData.getId()!=null){
        return dictDataMapper.updateByPrimaryKey(dictData);
        }
        return dictDataMapper.insert(dictData);
    }

    @Override
    public int deleteBatch(List<Integer> ids) {
        return dictDataMapper.deleteByIdList(ids);
    }
}
