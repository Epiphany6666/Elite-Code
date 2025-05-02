package cn.elitecode.service;

import cn.elitecode.common.api.CommonPage;
import cn.elitecode.model.dto.menu.MenuAddDTO;
import cn.elitecode.model.dto.menu.MenuQueryDTO;
import cn.elitecode.model.dto.menu.MenuUpdateDTO;
import cn.elitecode.model.entity.Menu;

/**
* menu(菜单权限表) | 业务层
*/
public interface MenuService {

    /**
     * 新增菜单
     * @param menuAddDTO
     * @return
     */
    Long addMenu(MenuAddDTO menuAddDTO);

    /**
     * 批量移除菜单
     * @param menuIds
     */
    void removeMenu(Long[] menuIds);

    /**
     * 根据id修改菜单
     * @param menuUpdateDTO
     */
    void updateMenu(MenuUpdateDTO menuUpdateDTO);

    /**
     * 根据分页条件查询菜单
     * @param menuQueryDTO
     * @return
     */
    CommonPage<Menu> selectMenuListByPage(MenuQueryDTO menuQueryDTO);

    /**
     * 根据id查询菜单
     * @param menuId
     * @return
     */
    Menu getMenuById(Long menuId);
}
