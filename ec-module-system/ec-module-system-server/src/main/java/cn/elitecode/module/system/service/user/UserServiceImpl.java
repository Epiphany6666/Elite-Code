package cn.elitecode.module.system.service.user;

import cn.elitecode.framework.common.enums.HttpStatus;
import cn.elitecode.framework.common.pojo.CommonPage;
import cn.elitecode.framework.security.core.utils.SecurityUtil;
import cn.elitecode.module.system.controller.admin.user.vo.UserAddDTO;
import cn.elitecode.module.system.controller.admin.user.vo.UserQueryDTO;
import cn.elitecode.module.system.controller.admin.user.vo.UserUpdateDTO;
import cn.elitecode.module.system.controller.admin.user.vo.UserUpdateProfileDto;
import cn.elitecode.module.system.dal.dataobject.permission.UserRoleDO;
import cn.elitecode.module.system.dal.dataobject.user.UserDO;
import cn.elitecode.module.system.dal.mysql.permmison.UserRoleMapper;
import cn.elitecode.module.system.dal.mysql.user.UserMapper;
import cn.elitecode.module.system.enums.UserConstant;
import cn.elitecode.module.system.exception.user.AdminNotAllowedException;
import cn.elitecode.module.system.exception.user.UsernameAlreadyExistsException;
import cn.hutool.core.util.ObjectUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户表（user） | 业务处理层
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public CommonPage<UserDO> selectUserList(UserQueryDTO userQueryDTO) {
        if (userQueryDTO.getCurrent() != null && userQueryDTO.getPageSize() != null) {
            userQueryDTO.setCurrent((userQueryDTO.getCurrent() - 1) * userQueryDTO.getPageSize());
        }
        List<UserDO> userDOList = userMapper.selectUserList(userQueryDTO);
        Long total = userMapper.getUserTotal(userQueryDTO);
        CommonPage<UserDO> page = new CommonPage<>(total, userDOList);
        return page;
    }

    @Override
    @Transactional
    public void updateUser(UserUpdateDTO userUpdateDTO) {
        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(userUpdateDTO, userDO);
        userDO.setUpdateBy(SecurityUtil.getUserId());
        userMapper.updateUserById(userDO);

        // 删除用户角色关联
        userRoleMapper.deleteUserRoleByUserId(userDO.getId());
        // 新增用户角色关联
        insertUserRole(userDO.getId(), userUpdateDTO.getRoleIds());
    }

    @Override
    public boolean checkUsernameUnique(UserDO userDO) {
        Long userId = ObjectUtil.isNull(userDO.getId()) ? -1L : userDO.getId();
        UserDO info = userMapper.checkUsernameUnique(userDO.getUsername());
        if (ObjectUtil.isNotNull(info) && info.getId().longValue() != userId.longValue()) {
            return UserConstant.NOT_UNIQUE;
        }
        return UserConstant.UNIQUE;
    }

    @Override
    @Transactional
    public Long addUser(UserAddDTO userAddDTO) {
        // 新增用户
        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(userAddDTO, userDO);
        if (!checkUsernameUnique(userDO)) {
            throw new UsernameAlreadyExistsException(HttpStatus.PARAMS_ERROR, "新增用户 '" + userDO.getUsername() + "' 失败，账号已存在");
        }
        userDO.setCreateBy(SecurityUtil.getUserId());
        userDO.setPassword(SecurityUtil.encryptPassword(userAddDTO.getPassword()));
        userMapper.insertUser(userDO);

        // 新增用户角色关联
        insertUserRole(userDO.getId(), userAddDTO.getRoleIds());
        return userDO.getId();
    }

    @Override
    @Transactional
    public void removeByUserIds(Long[] userIds) {
        for (Long userId : userIds) {
            checkUserAllowed(new UserDO(userId));
        }
        // 从用户表中删除用户
        userMapper.deleteUserByIds(userIds);
        // 从用户角色表中删除用户角色关联
        userRoleMapper.deleteUserRoleByUserIds(userIds);
    }

    @Override
    public boolean updateUserAvatar(Long userId, String avatarUrl) {
        userMapper.updateAvatar(userId, avatarUrl);
        return true;
    }

    @Override
    public UserDO selectUserById(Long userId) {
        UserDO userDO = userMapper.selectUserById(userId);
        return userDO;
    }

    @Override
    public void updateUserProfile(UserUpdateProfileDto userUpdateProfileDto) {
        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(userUpdateProfileDto, userDO);
        userDO.setUpdateBy(SecurityUtil.getUserId());
        userDO.setId(SecurityUtil.getUserId());
        userMapper.updateUserById(userDO);
    }

    private void checkUserAllowed(UserDO userDO) {
        if (ObjectUtil.isNotNull(userDO.getId()) && isAdmin(userDO.getId())) {
            throw new AdminNotAllowedException(HttpStatus.ADMIN_NOT_ALLOWED_ERROR, "不允许操作超级管理员用户");
        }
    }

    private boolean isAdmin(Long userId) {
        return userId != null && 1L == userId;
    }

    /**
     * 批量新增用户角色关联
     *
     * @param userId
     * @param roleIds
     */
    private void insertUserRole(Long userId, List<Long> roleIds) {
        List<UserRoleDO> userRoleDOList = new ArrayList<>();
        for (Long roleId : roleIds) {
            userRoleDOList.add(new UserRoleDO(userId, roleId));
        }
        userRoleMapper.batchUserRole(userRoleDOList);
    }

}
