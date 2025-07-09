package cn.elitecode.module.system.service.permmision;

import cn.elitecode.framework.common.enums.HttpStatus;
import cn.elitecode.framework.common.pojo.CommonPage;
import cn.elitecode.framework.security.core.utils.SecurityUtil;
import cn.elitecode.module.system.controller.admin.permmision.vo.role.RoleAddReqVO;
import cn.elitecode.module.system.controller.admin.permmision.vo.role.RoleQueryReqVO;
import cn.elitecode.module.system.controller.admin.permmision.vo.role.RoleUpdateReqVO;
import cn.elitecode.module.system.dal.dataobject.permission.ResourceDO;
import cn.elitecode.module.system.dal.dataobject.permission.RoleDO;
import cn.elitecode.module.system.dal.dataobject.permission.RoleMenuDO;
import cn.elitecode.module.system.dal.mysql.permmison.ResourceMapper;
import cn.elitecode.module.system.dal.mysql.permmison.RoleMapper;
import cn.elitecode.module.system.dal.mysql.permmison.RoleMenuMapper;
import cn.elitecode.module.system.dal.mysql.permmison.UserRoleMapper;
import cn.elitecode.module.system.exception.role.RoleAlreadyAssignException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
* role(角色信息表) | 业务处理层
*/
@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private RoleMenuMapper roleMenuMapper;
    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    @Transactional
    public Long addRole(RoleAddReqVO roleAddReqVO) {
        // 新增角色
        RoleDO roleDO = new RoleDO();
        BeanUtils.copyProperties(roleAddReqVO, roleDO);
        roleDO.setCreateBy(SecurityUtil.getUserId());
        roleMapper.insertRole(roleDO);
        // 新增角色菜单关联
        insertRoleMenu(roleDO.getId(), roleAddReqVO.getMenuIds());
        return roleDO.getId();
    }

    @Override
    @Transactional
    public void removeRoleByIds(Long[] roleIds) {
        for (Long roleId : roleIds) {
            RoleDO roleDO = roleMapper.selectRoleById(roleId);
            int count = userRoleMapper.countUserRoleByRoleId(roleId);
            if (count > 0) {
                throw new RoleAlreadyAssignException(HttpStatus.PARAMS_ERROR, roleDO.getName() + "已分配，不能删除");
            }
        }
        // 删除角色表信息
        roleMapper.removeRoleByIds(roleIds);
        // 删除角色菜单关联
        roleMenuMapper.deleteRoleMenuByIds(roleIds);
    }

    @Override
    @Transactional
    public void updateRole(RoleUpdateReqVO roleUpdateReqVO) {
        // 更新角色信息
        RoleDO roleDO = new RoleDO();
        BeanUtils.copyProperties(roleUpdateReqVO, roleDO);
        roleDO.setUpdateBy(SecurityUtil.getUserId());
        roleMapper.updateRoleById(roleDO);
        // 删除角色菜单关联
        roleMenuMapper.deleteRoleMenuById(roleUpdateReqVO.getId());
        // 新增角色菜单关联
        insertRoleMenu(roleUpdateReqVO.getId(), roleUpdateReqVO.getMenuIds());
    }

    @Override
    public CommonPage<RoleDO> selectRoleListByPage(RoleQueryReqVO roleQueryReqVO) {
        if (roleQueryReqVO.getCurrent() != null && roleQueryReqVO.getPageSize() != null) {
            roleQueryReqVO.setCurrent((roleQueryReqVO.getCurrent() - 1) * roleQueryReqVO.getPageSize());
        }
        List<RoleDO> roleDOList = roleMapper.selectRoleListByPage(roleQueryReqVO);
        Long total = roleMapper.getTotal(roleQueryReqVO);
        CommonPage<RoleDO> page = new CommonPage<>(total, roleDOList);
        return page;
    }

    @Override
    public List<RoleDO> selectRoleListAll() {
        List<RoleDO> roleDOList = roleMapper.selectRoleListAll();
        return roleDOList;
    }

    @Override
    public RoleDO selectRoleById(Long roleId) {
        RoleDO roleDO = roleMapper.selectRoleById(roleId);
        return roleDO;
    }

    @Override
    public List<ResourceDO> listResourceByRoleId(Long roleId) {
        List<ResourceDO> resourceDOList = resourceMapper.listResourceByRoleId(roleId);
        return resourceDOList;
    }

    /**
     * 批量新增角色菜单联系
     * @param roleId
     * @param menuIds
     */
    private void insertRoleMenu(Long roleId, List<Long> menuIds) {
        List<RoleMenuDO> roleMenuDOList = new ArrayList<>();
        for (Long menuId : menuIds) {
            roleMenuDOList.add(new RoleMenuDO(roleId, menuId));
        }
        roleMenuMapper.batchRoleMenu(roleMenuDOList);
    }
}




