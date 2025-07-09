package cn.elitecode.module.system.service.permmision;

import cn.elitecode.framework.common.pojo.CommonPage;
import cn.elitecode.module.system.controller.admin.permmision.vo.role.RoleAddReqVO;
import cn.elitecode.module.system.controller.admin.permmision.vo.role.RoleQueryReqVO;
import cn.elitecode.module.system.controller.admin.permmision.vo.role.RoleUpdateReqVO;
import cn.elitecode.module.system.dal.dataobject.permission.ResourceDO;
import cn.elitecode.module.system.dal.dataobject.permission.RoleDO;

import java.util.List;

/**
* role(角色信息表) | 业务层
*/
public interface RoleService {

    /**
     * 新增角色
     * @param roleAddReqVO
     * @return
     */
    Long addRole(RoleAddReqVO roleAddReqVO);

    /**
     * 根据id数组批量删除角色
     * @param roleIds
     */
    void removeRoleByIds(Long[] roleIds);

    /**
     * 根据id修改角色信息
     * @param roleUpdateReqVO
     */
    void updateRole(RoleUpdateReqVO roleUpdateReqVO);

    /**
     * 根据分页条件查询角色信息
     * @param roleQueryReqVO
     * @return
     */
    CommonPage<RoleDO> selectRoleListByPage(RoleQueryReqVO roleQueryReqVO);

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

    /**
     * 获取角色相关后台资源
     * @param roleId
     * @return
     */
    List<ResourceDO> listResourceByRoleId(Long roleId);
}
