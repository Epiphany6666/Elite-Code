package cn.elitecode.module.system.service.permmision;

import cn.elitecode.framework.common.pojo.CommonPage;
import cn.elitecode.module.system.controller.admin.menu.vo.MenuAddReqVO;
import cn.elitecode.module.system.controller.admin.menu.vo.MenuQueryReqVO;
import cn.elitecode.module.system.controller.admin.menu.vo.MenuUpdateReqVO;
import cn.elitecode.module.system.dal.dataobject.TreeSelect;
import cn.elitecode.module.system.dal.dataobject.menu.MenuDO;

import java.util.List;

/**
* menu(菜单权限表) | 业务层
*/
public interface MenuService {

    /**
     * 新增菜单
     * @param menuAddReqVO
     * @return
     */
    Long addMenu(MenuAddReqVO menuAddReqVO);

    /**
     * 批量移除菜单
     * @param menuIds
     */
    void removeMenu(Long[] menuIds);

    /**
     * 根据id修改菜单
     * @param menuUpdateReqVO
     */
    void updateMenu(MenuUpdateReqVO menuUpdateReqVO);

    /**
     * 根据分页条件查询菜单
     * @param menuQueryReqVO
     * @return
     */
    CommonPage<MenuDO> selectMenuListByPage(MenuQueryReqVO menuQueryReqVO);

    /**
     * 根据id查询菜单
     * @param menuId
     * @return
     */
    MenuDO getMenuById(Long menuId);

    /**
     * 根据用户id查询菜单列表
     * @param userId
     * @return
     */
    List<MenuDO> selectMenuListByUserId(Long userId);

    /**
     * 根据角色id查询菜单信息
     * @param roleId 角色id
     * @return 选中菜单列表
     */
    List<Long> selectMenuListByRoleId(Long roleId);

    /**
     * 构建前端所需要的下拉树结构
     * @param menuDOList 菜单列表
     * @return 下拉树结构列表
     */
    List<TreeSelect> buildMenuTreeSelect(List<MenuDO> menuDOList);
}
