package cn.elitecode.mapper;

import cn.elitecode.model.dto.role.RoleQueryDTO;
import cn.elitecode.model.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
* role(角色信息表)
*/
@Mapper
public interface RoleMapper {

    /**
     * 插入角色
     * @param role
     */
    void insertRole(Role role);

    /**
     * 根据id数组批量删除角色
     * @param roleIds
     */
    void removeRoleByIds(@Param("roleIds") Long[] roleIds);

    /**
     * 根据id修改角色信息
     * @param role
     */
    void updateRoleById(Role role);

    /**
     * 根据分页条件查询角色信息
     * @param roleQueryDTO
     * @return
     */
    List<Role> selectRoleListByPage(RoleQueryDTO roleQueryDTO);

    /**
     * 根据条件查询角色总数量
     * @param roleQueryDTO
     * @return
     */
    Long getTotal(RoleQueryDTO roleQueryDTO);

    /**
     * 查询全部角色信息
     * @return
     */
    List<Role> selectRoleListAll();

    /**
     * 根据id查询角色信息
     * @param roleId
     * @return
     */
    Role selectRoleById(Long roleId);
}