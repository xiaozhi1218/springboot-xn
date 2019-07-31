package com.mtl.system.service;

import com.mtl.system.domain.Iconfont;
import com.mtl.common.tool.model.Page;
import java.util.List;
/**
 *  服务类
 *
 * @author lsc
 * @since 2019-04-03
 */
public interface IIconfontService {

        Page<Iconfont> findPage(Integer page,Integer size);
}
