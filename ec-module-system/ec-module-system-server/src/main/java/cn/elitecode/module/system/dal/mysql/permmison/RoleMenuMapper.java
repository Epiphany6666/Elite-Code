package cn.elitecode.module.system.dal.mysql.permmison;

import cn.elitecode.module.system.dal.dataobject.permission.RoleMenuDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* system_role_menu_relation(角色和菜单关联表)
*/
@Mapper
public interface RoleMenuMapper {

    /**
     * 批量插入角色菜单联系
     * @param roleMenuDOList
     */
    void batchRoleMenu(@Param("roleMenuDOList") List<RoleMenuDO> roleMenuDOList);

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




