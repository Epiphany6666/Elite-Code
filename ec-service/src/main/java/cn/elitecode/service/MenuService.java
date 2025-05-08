package cn.elitecode.service;

import cn.elitecode.common.api.CommonPage;
import cn.elitecode.model.bo.TreeSelect;
import cn.elitecode.model.dto.menu.MenuAddDTO;
import cn.elitecode.model.dto.menu.MenuQueryDTO;
import cn.elitecode.model.dto.menu.MenuUpdateDTO;
import cn.elitecode.model.entity.Menu;
import java.util.List;

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

    /**
     * 根据用户id查询菜单列表
     * @param userId
     * @return
     */
    List<Menu> selectMenuListByUserId(Long userId);

    /**
     * 根据角色id查询菜单信息
     * @param roleId 角色id
     * @return 选中菜单列表
     */
    List<Long> selectMenuListByRoleId(Long roleId);

    /**
     * 构建前端所需要的下拉树结构
     * @param menuList 菜单列表
     * @return 下拉树结构列表
     */
    List<TreeSelect> buildMenuTreeSelect(List<Menu> menuList);
}
