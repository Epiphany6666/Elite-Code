package cn.elitecode.mapper;

import cn.elitecode.model.entity.RoleResource;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
* role_resource(角色资源关联表)
*/
public interface RoleResourceMapper {

    /**
     * 根据角色id删除角色资源关联
     * @param roleId
     */
    void deleteRoleResourceByRoleId(Long roleId);

    /**
     * 批量新增角色资源信息
     * @param roleResourceList
     */
    void batchRoleResource(@Param("roleResourceList") List<RoleResource> roleResourceList);
}




