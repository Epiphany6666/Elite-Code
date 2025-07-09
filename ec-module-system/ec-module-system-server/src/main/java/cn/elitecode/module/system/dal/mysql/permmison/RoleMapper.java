package cn.elitecode.module.system.dal.mysql.permmison;

import cn.elitecode.module.system.controller.admin.permmision.vo.role.RoleQueryReqVO;
import cn.elitecode.module.system.dal.dataobject.permission.RoleDO;
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
     * @param roleDO
     */
    void insertRole(RoleDO roleDO);

    /**
     * 根据id数组批量删除角色
     * @param roleIds
     */
    void removeRoleByIds(@Param("roleIds") Long[] roleIds);

    /**
     * 根据id修改角色信息
     * @param roleDO
     */
    void updateRoleById(RoleDO roleDO);

    /**
     * 根据分页条件查询角色信息
     * @param roleQueryReqVO
     * @return
     */
    List<RoleDO> selectRoleListByPage(RoleQueryReqVO roleQueryReqVO);

    /**
     * 根据条件查询角色总数量
     * @param roleQueryReqVO
     * @return
     */
    Long getTotal(RoleQueryReqVO roleQueryReqVO);

    /**
     * 查询全部角色信息
     * @return
     */
    List<RoleDO> selectRoleListAll();

    /**
     * 根据id查询角色信息
     * @param roleId
     * @return
     */
    RoleDO selectRoleById(Long roleId);
}