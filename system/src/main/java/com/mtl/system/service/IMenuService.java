package com.mtl.system.service;

import com.mtl.common.tool.model.Page;
import com.mtl.system.domain.Menu;
import com.mtl.system.domain.Role;
import com.mtl.system.domain.vo.MenuVO;

import java.util.List;

/**
 *  服务类
 *
 * @author lsc
 * @since 2019-03-26
 */
public interface IMenuService {

    Menu findById(Integer id);

    int saveOrUpdate(Menu menu);

    int delete(Integer id);

    List<MenuVO> authMenuTree(Integer id);

    List<Menu> authMenu(Integer id);

    /*
	获取角色权限
	* */
    List<MenuVO> MenuTreeByRole(Integer roleId);

    Role getAuthUrlByUserId(Integer userId);
}
