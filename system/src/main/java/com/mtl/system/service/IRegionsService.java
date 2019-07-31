package com.mtl.system.service;

import com.mtl.system.domain.Regions;
import com.mtl.common.tool.model.Page;
import com.mtl.system.domain.vo.RegionsVO;

import java.util.List;
/**
 *  服务类
 *
 * @author lsc
 * @since 2019-04-14
 */
public interface IRegionsService {

        Regions findById(Integer id);

        Page<Regions> findPage(Integer page,Integer size);

        int saveOrUpdate(Regions regions);

        /*新增或修改节点*/
        int saveOrUpdateRegionsVO(Regions regions);

        /*删除节点*/
        int deleteRegionsVO(Regions regions);

        int deleteBatch(List<Integer> ids);

        int delete(Integer id);

        List<RegionsVO> regionsTree(Integer id);

        List<Regions> regions(Integer id);
}
