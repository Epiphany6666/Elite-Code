package cn.elitecode.service;

import cn.elitecode.common.api.CommonPage;
import cn.elitecode.model.dto.role.RoleAddDTO;
import cn.elitecode.model.dto.role.RoleQueryDTO;
import cn.elitecode.model.dto.role.RoleUpdateDTO;
import cn.elitecode.model.entity.Role;
import java.util.List;

/**
* role(角色信息表) | 业务层
*/
public interface RoleService {

    /**
     * 新增角色
     * @param roleAddDTO
     * @return
     */
    Long addRole(RoleAddDTO roleAddDTO);

    /**
     * 根据id数组批量删除角色
     * @param roleIds
     */
    void removeRoleByIds(Long[] roleIds);

    /**
     * 根据id修改角色信息
     * @param roleUpdateDTO
     */
    void updateRole(RoleUpdateDTO roleUpdateDTO);

    /**
     * 根据分页条件查询角色信息
     * @param roleQueryDTO
     * @return
     */
    CommonPage<Role> selectRoleListByPage(RoleQueryDTO roleQueryDTO);

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
