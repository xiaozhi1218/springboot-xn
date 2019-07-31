package com.mtl.system.service.impl;


import com.alibaba.fastjson.JSONArray;
import com.mtl.common.tool.node.ForestNodeMerger;
import com.mtl.system.domain.AdminUser;
import com.mtl.system.domain.Menu;
import com.mtl.system.domain.Role;
import com.mtl.system.domain.vo.MenuVO;
import com.mtl.system.mapper.AdminUserMapper;
import com.mtl.system.mapper.MenuMapper;
import com.mtl.system.mapper.RoleMapper;
import com.mtl.system.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *  服务实现类
 *
 * @author lsc
 * @since 2019-03-26
 */
@Service
public class MenuServiceImpl implements IMenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private AdminUserMapper userMapper;
    @Override
    public Menu findById(Integer id) {
        return menuMapper.selectByPrimaryKey(id);
    }

    @Override
    public int saveOrUpdate(Menu menu) {
        if(menu.getId()!=null){
            return menuMapper.updateByPrimaryKey(menu);
        }
        menu.setDeleteflag(0);
        menu.setIsDisplay(0);
        if(menu.getPid()==null) {
            menu.setPid(0);
        }
        if (menu.getPid() == 0) {
            menu.setType(0);
        } else {
            menu.setType(1);
        }
        return menuMapper.insert(menu);
    }

    @Override
    public int delete(Integer id) {
        int children=menuMapper.findByParentId(id);
        if(children>0) {
            return -1;
        }
        return menuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<MenuVO> authMenuTree(Integer id) {
         AdminUser user=userMapper.selectByPrimaryKey(id);
         Role role=roleMapper.selectAuthUrls(id);
        List<Integer> listids=new ArrayList<>();
        List<MenuVO> trees=null;
        if(user.getUsername().equals("admin")){
            trees= ForestNodeMerger.merge(menuMapper.authMenu(listids));
        } else if((role.getAuthAction()==null&& role.getAuthAction()=="")){
            return null;
        }else if(role.getAuthAction()!=null&& role.getAuthAction()!=""){//非admin用户
            JSONArray jsonArray=JSONArray.parseArray(role.getAuthAction());
            List<Map> list=jsonArray.toJavaList(Map.class);
            list.forEach(ids->{
                listids.add((Integer) ids.get("parentId"));
                ((List<Map>)ids.get("menu")).forEach(menu->{
                    listids.add((Integer) menu.get("id"));
                });
            });
            trees= ForestNodeMerger.merge(menuMapper.authMenu(listids));
        }
        return trees;
    }

    @Override
    public List<Menu> authMenu(Integer id) {
        List<String> list=menuMapper.authMenuIds(id);
        StringBuffer ids=new StringBuffer();
        for(String s:list){
            ids.append(s).append(",");
        }
        if(ids.length()>0) {
            ids.deleteCharAt(ids.length()-1);
        }
        List<Menu> menus= menuMapper.authMenuList(ids.toString());
        return menus;
    }

    @Override
    /*
	获取角色权限
	* */
    public List<MenuVO> MenuTreeByRole(Integer roleId){
        List<MenuVO> list=menuMapper.MenuTreeByRole(roleId);
        Role role=roleMapper.selectByPrimaryKey(roleId);
//        遍历查询菜单
        for (MenuVO menuVo:list) {
            List<Map> mapList=new ArrayList<>();
//            菜单为二级菜单时追加菜单按钮和选中状态
            if(menuVo.getParentId()>0){
//                菜单按钮转化为list 追加
                JSONArray jsonArray = JSONArray.parseArray(menuVo.getMenuButtons());
                mapList = jsonArray.toJavaList(Map.class);
//                菜单选中状态追加
                if(role.getAuthAction()!=""&& role.getAuthAction()!=null){
                    JSONArray jsonArraySelect = JSONArray.parseArray(role.getAuthAction());
                    List<Map> listselect = (List<Map>) jsonArraySelect.toJavaList(Map.class);
                    listselect.forEach(mapselect->{
                        if(mapselect.get("parentId")==menuVo.getParentId()){
                            ((List<Map<String,Object>>)mapselect.get("menu")).forEach(menu->{
                                if(menu.get("id").equals(menuVo.getId())){
                                    menuVo.setSelectchecked((List<String>) menu.get("selectedbutton"));
                                }
                            });
                        }
                    });
                }
            }
            menuVo.setListMenuButtons(mapList);
        }
        List<MenuVO> trees= ForestNodeMerger.merge(list);
        return trees;
    }

    @Override
    public Role getAuthUrlByUserId(Integer userId) {
        Role authUrl=roleMapper.selectAuthUrls(userId);
        return authUrl;
    }

}
