package cn.elitecode.service.impl;

import cn.elitecode.common.api.CommonPage;
import cn.elitecode.common.exception.role.RoleAlreadyAssignException;
import cn.elitecode.common.utils.SecurityUtils;
import cn.elitecode.constant.HttpStatus;
import cn.elitecode.mapper.RoleMapper;
import cn.elitecode.mapper.UserRoleMapper;
import cn.elitecode.model.dto.role.RoleAddDTO;
import cn.elitecode.model.dto.role.RoleQueryDTO;
import cn.elitecode.model.dto.role.RoleUpdateDTO;
import cn.elitecode.model.entity.Role;
import cn.elitecode.service.RoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    @Override
    public Long addRole(RoleAddDTO roleAddDTO) {
        Role role = new Role();
        BeanUtils.copyProperties(roleAddDTO, role);
        role.setCreateBy(SecurityUtils.getUserId());
        roleMapper.insertRole(role);
        return role.getId();
    }

    @Override
    public void removeRoleByIds(Long[] roleIds) {
        for (Long roleId : roleIds) {
            Role role = roleMapper.selectRoleById(roleId);
            int count = userRoleMapper.countUserRoleByRoleId(roleId);
            if (count > 0) {
                throw new RoleAlreadyAssignException(HttpStatus.PARAMS_ERROR, role.getName() + "已分配，不能删除");
            }
        }
        roleMapper.removeRoleByIds(roleIds);
    }

    @Override
    public void updateRole(RoleUpdateDTO roleUpdateDTO) {
        Role role = new Role();
        BeanUtils.copyProperties(roleUpdateDTO, role);
        role.setUpdateBy(SecurityUtils.getUserId());
        roleMapper.updateRoleById(role);
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
}




