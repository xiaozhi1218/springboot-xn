package com.mtl.system.service.impl;

import com.mtl.common.tool.node.ForestNodeMerger;
import com.mtl.system.domain.Regions;
import com.mtl.system.domain.vo.RegionsVO;
import com.mtl.system.mapper.RegionsMapper;
import com.mtl.system.service.IRegionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.mtl.common.tool.model.Page;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 *  服务实现类
 *
 * @author lsc
 * @since 2019-04-14
 */
@Service
public class RegionsServiceImpl implements IRegionsService {

    @Autowired
    private RegionsMapper regionsMapper;

    @Override
    public Regions findById(Integer id) {
        return regionsMapper.selectByPrimaryKey(id);
    }

    @Override
    public Page<Regions> findPage(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        List<Regions> regionss=regionsMapper.selectAll();
        return new Page<>(regionss);
    }

    @Override
    public int saveOrUpdate(Regions regions) {
        if(regions.getId()!=null){
        return regionsMapper.updateByPrimaryKey(regions);
        }
        return regionsMapper.insert(regions);
    }

    /*删除节点*/
    @Override
    public int deleteRegionsVO(Regions regions){
        Integer count=regionsMapper.selectUserInRegion(regions.getId());
        Integer count2=regionsMapper.selectRoleInRegion(regions.getId());

        if(count>0||count2>0){
            return 0;//关联用户或角色大于0，不允许删除
        }
        else{
            regionsMapper.deleteRegionsVO(regions.getId());
            return 1;//成功删除
        }

    }

    /*新增或修改节点*/
    @Override
    public int saveOrUpdateRegionsVO(Regions regions) {
        if(regions.getId()!=null){
            return regionsMapper.updateRegionsVO(regions);
        }
         Integer su=regionsMapper.insertRegionsVO(regions);
        if(su==1){
            int id=regions.getId();
            Regions r=regionsMapper.selectRegions(id);
            String path=r.getRegionPath();
            path=path+r.getId()+",";
            r.setRegionPath(path);
            return regionsMapper.updateRegionsVO(r);
        }
        else {
            return 0;
        }

    }

    @Override
    public int deleteBatch(List<Integer> ids) {
        return regionsMapper.deleteByIdList(ids);
    }

    @Override
    public int delete(Integer id) {
        int children=regionsMapper.findByParentId(id);
        if(children>0) {
            return -1;
        }
        return regionsMapper.deleteByPrimaryKey(id);
    }


    //初级菜单
    @Override
    public List<RegionsVO> regionsTree(Integer id) {
          Integer[] array=regionsMapper.authRegionsIds(id);
          List<RegionsVO> trees= ForestNodeMerger.merge(regionsMapper.regions(array));
          return trees;

    }


    @Override
    public List<Regions> regions(Integer id) {

            List<Regions> regions= regionsMapper.regionsList(id);
            return regions;


    }
}
