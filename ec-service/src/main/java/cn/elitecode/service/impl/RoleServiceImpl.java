package cn.elitecode.service.impl;

import cn.elitecode.common.api.CommonPage;
import cn.elitecode.common.exception.role.RoleAlreadyAssignException;
import cn.elitecode.constant.HttpStatus;
import cn.elitecode.framework.core.utils.SecurityUtil;
import cn.elitecode.mapper.ResourceMapper;
import cn.elitecode.mapper.RoleMapper;
import cn.elitecode.mapper.RoleMenuMapper;
import cn.elitecode.mapper.UserRoleMapper;
import cn.elitecode.model.dto.role.RoleAddDTO;
import cn.elitecode.model.dto.role.RoleQueryDTO;
import cn.elitecode.model.dto.role.RoleUpdateDTO;
import cn.elitecode.model.entity.Resource;
import cn.elitecode.model.entity.Role;
import cn.elitecode.model.entity.RoleMenu;
import cn.elitecode.service.RoleService;
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
    public Long addRole(RoleAddDTO roleAddDTO) {
        // 新增角色
        Role role = new Role();
        BeanUtils.copyProperties(roleAddDTO, role);
        role.setCreateBy(SecurityUtil.getUserId());
        roleMapper.insertRole(role);
        // 新增角色菜单关联
        insertRoleMenu(role.getId(), roleAddDTO.getMenuIds());
        return role.getId();
    }

    @Override
    @Transactional
    public void removeRoleByIds(Long[] roleIds) {
        for (Long roleId : roleIds) {
            Role role = roleMapper.selectRoleById(roleId);
            int count = userRoleMapper.countUserRoleByRoleId(roleId);
            if (count > 0) {
                throw new RoleAlreadyAssignException(HttpStatus.PARAMS_ERROR, role.getName() + "已分配，不能删除");
            }
        }
        // 删除角色表信息
        roleMapper.removeRoleByIds(roleIds);
        // 删除角色菜单关联
        roleMenuMapper.deleteRoleMenuByIds(roleIds);
    }

    @Override
    @Transactional
    public void updateRole(RoleUpdateDTO roleUpdateDTO) {
        // 更新角色信息
        Role role = new Role();
        BeanUtils.copyProperties(roleUpdateDTO, role);
        role.setUpdateBy(SecurityUtil.getUserId());
        roleMapper.updateRoleById(role);
        // 删除角色菜单关联
        roleMenuMapper.deleteRoleMenuById(roleUpdateDTO.getId());
        // 新增角色菜单关联
        insertRoleMenu(roleUpdateDTO.getId(), roleUpdateDTO.getMenuIds());
    }

    @Override
    public CommonPage<Role> selectRoleListByPage(RoleQueryDTO roleQueryDTO) {
        if (roleQueryDTO.getCurrent() != null && roleQueryDTO.getPageSize() != null) {
            roleQueryDTO.setCurrent((roleQueryDTO.getCurrent() - 1) * roleQueryDTO.getPageSize());
        }
        List<Role> roleList = roleMapper.selectRoleListByPage(roleQueryDTO);
        Long total = roleMapper.getTotal(roleQueryDTO);
        CommonPage<Role> page = new CommonPage<>(total, roleList);
        return page;
    }

    @Override
    public List<Role> selectRoleListAll() {
        List<Role> roleList = roleMapper.selectRoleListAll();
        return roleList;
    }

    @Override
    public Role selectRoleById(Long roleId) {
        Role role = roleMapper.selectRoleById(roleId);
        return role;
    }

    @Override
    public List<Resource> listResourceByRoleId(Long roleId) {
        List<Resource> resourceList = resourceMapper.listResourceByRoleId(roleId);
        return resourceList;
    }

    /**
     * 批量新增角色菜单联系
     * @param roleId
     * @param menuIds
     */
    private void insertRoleMenu(Long roleId, List<Long> menuIds) {
        List<RoleMenu> roleMenuList = new ArrayList<>();
        for (Long menuId : menuIds) {
            roleMenuList.add(new RoleMenu(roleId, menuId));
        }
        roleMenuMapper.batchRoleMenu(roleMenuList);
    }
}




