package cn.elitecode.module.system.dal.mysql.permmison;

import cn.elitecode.module.system.dal.dataobject.permission.RoleResourceDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* system_role_resource_relation(角色资源关联表)
*/
@Mapper
public interface RoleResourceMapper {

    /**
     * 根据角色id删除角色资源关联
     * @param roleId
     */
    void deleteRoleResourceByRoleId(Long roleId);

    /**
     * 批量新增角色资源信息
     * @param roleResourceDOList
     */
    void batchRoleResource(@Param("roleResourceDOList") List<RoleResourceDO> roleResourceDOList);
}




