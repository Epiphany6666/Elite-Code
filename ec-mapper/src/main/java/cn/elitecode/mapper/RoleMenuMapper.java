package cn.elitecode.mapper;

import cn.elitecode.model.entity.RoleMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
* role_menu(角色和菜单关联表)
*/
@Mapper
public interface RoleMenuMapper {

    /**
     * 批量插入角色菜单联系
     * @param roleMenuList
     */
    void batchRoleMenu(@Param("roleMenuList") List<RoleMenu> roleMenuList);

    /**
     * 根据角色id删除角色菜单关联
     * @param roleId
     */
    void deleteRoleMenuById(Long roleId);

    /**
     * 根据角色id数组删除角色菜单关联
     * @param roleIds
     */
    void deleteRoleMenuByIds(@Param("roleIds") Long[] roleIds);
}




