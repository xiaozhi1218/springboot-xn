package com.mtl.system.service.impl;

import com.mtl.system.domain.Iconfont;
import com.mtl.system.mapper.IconfontMapper;
import com.mtl.system.service.IIconfontService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.mtl.common.tool.model.Page;

import java.util.List;
/**
 *  服务实现类
 *
 * @author lsc
 * @since 2019-04-03
 */
@Service
public class IconfontServiceImpl implements IIconfontService {

    @Autowired
    private IconfontMapper iconfontMapper;

    @Override
    public Page<Iconfont> findPage(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        List<Iconfont> iconfonts=iconfontMapper.selectAll();
        return new Page<>(iconfonts);
    }
}
