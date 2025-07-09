package cn.elitecode.module.system.dal.mysql.menu;

import cn.elitecode.module.system.controller.admin.menu.vo.MenuQueryReqVO;
import cn.elitecode.module.system.dal.dataobject.menu.MenuDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* menu(菜单权限表)
*/
@Mapper
public interface MenuMapper {

    /**
     * 插入菜单信息
     * @param system_menu
     */
    void insertMenu(MenuDO menuDO);

    /**
     * 根据id数组批量删除菜单信息
     * @param menuIds
     */
    void deleteByMenuIds(@Param("menuIds") Long[] menuIds);

    /**
     * 根据id修改菜单信息
     * @param system_menu
     */
    void updateMenuById(MenuDO menuDO);

    /**
     * 根据分页条件查询菜单信息
     * @param menuQueryReqVO
     * @return
     */
    List<MenuDO> selectMenuListByPage(MenuQueryReqVO menuQueryReqVO);

    /**
     * 根据分页条件查询菜单信息数量
     * @param menuQueryReqVO
     * @return
     */
    Long getTotalByPage(MenuQueryReqVO menuQueryReqVO);

    /**
     * 根据id查询菜单信息
     * @param menuId
     * @return
     */
    MenuDO selectMenuById(Long menuId);

    /**
     * 根据用户id查询菜单列表
     * @param userId
     * @return
     */
    List<MenuDO> selectMenuListByUserId(Long userId);

    /**
     * 根据角色id查询菜单列表
     * @param roleId
     * @param menuCheckStrictly
     * @return 选中菜单列表
     */
    List<Long> selectMenuListByRoleId(@Param("roleId") Long roleId, @Param("menuCheckStrictly") boolean menuCheckStrictly);
}




