package cn.elitecode.service.impl;

import cn.elitecode.common.BaseContext;
import cn.elitecode.common.api.CommonPage;
import cn.elitecode.common.exception.user.AdminNotAllowedException;
import cn.elitecode.common.exception.user.UsernameAlreadyExistsException;
import cn.elitecode.common.utils.SecurityUtils;
import cn.elitecode.constant.HttpStatus;
import cn.elitecode.constant.UserConstant;
import cn.elitecode.mapper.UserMapper;
import cn.elitecode.mapper.UserRoleMapper;
import cn.elitecode.model.dto.user.UserAddDTO;
import cn.elitecode.model.dto.user.UserQueryDTO;
import cn.elitecode.model.dto.user.UserUpdateDTO;
import cn.elitecode.model.entity.User;
import cn.elitecode.model.entity.UserRole;
import cn.elitecode.service.UserService;
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
    public CommonPage<User> selectUserList(UserQueryDTO userQueryDTO) {
        if (userQueryDTO.getCurrent() != null && userQueryDTO.getPageSize() != null) {
            userQueryDTO.setCurrent((userQueryDTO.getCurrent() - 1) * userQueryDTO.getPageSize());
        }
        List<User> userList = userMapper.selectUserList(userQueryDTO);
        Long total = userMapper.getUserTotal(userQueryDTO);
        CommonPage<User> page = new CommonPage<>(total, userList);
        return page;
    }

    @Override
    @Transactional
    public void updateUser(UserUpdateDTO userUpdateDTO) {
        User user = new User();
        BeanUtils.copyProperties(userUpdateDTO, user);
        user.setUpdateBy(BaseContext.getCurrentId());
        userMapper.updateUserById(user);

        // 删除用户角色关联
        userRoleMapper.deleteUserRoleByUserId(user.getId());
        // 新增用户角色关联
        insertUserRole(user.getId(), userUpdateDTO.getRoleIds());
    }

    @Override
    public boolean checkUsernameUnique(User user) {
        Long userId = ObjectUtil.isNull(user.getId()) ? -1L : user.getId();
        User info = userMapper.checkUsernameUnique(user.getUsername());
        if (ObjectUtil.isNotNull(info) && info.getId().longValue() != userId.longValue()) {
            return UserConstant.NOT_UNIQUE;
        }
        return UserConstant.UNIQUE;
    }

    @Override
    @Transactional
    public Long addUser(UserAddDTO userAddDTO) {
        // 新增用户
        User user = new User();
        BeanUtils.copyProperties(userAddDTO, user);
        if (!checkUsernameUnique(user)) {
            throw new UsernameAlreadyExistsException(HttpStatus.PARAMS_ERROR, "新增用户 '" + user.getUsername() + "' 失败，账号已存在");
        }
        user.setCreateBy(BaseContext.getCurrentId());
        user.setPassword(SecurityUtils.encryptPassword(userAddDTO.getPassword()));
        userMapper.insertUser(user);

        // 新增用户角色关联
        insertUserRole(user.getId(), userAddDTO.getRoleIds());
        return user.getId();
    }

    @Override
    @Transactional
    public void removeByUserIds(Long[] userIds) {
        for (Long userId : userIds) {
            checkUserAllowed(new User(userId));
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
    public User selectUserById(Long userId) {
        User user = userMapper.selectUserById(userId);
        return user;
    }

    private void checkUserAllowed(User user) {
        if (ObjectUtil.isNotNull(user.getId()) && isAdmin(user.getId())) {
            throw new AdminNotAllowedException(HttpStatus.ADMIN_NOT_ALLOWED_ERROR, "不允许操作超级管理员用户");
        }
    }

    private boolean isAdmin(Long userId) {
        return userId != null && 1L == userId;
    }

    /**
     * 批量新增用户角色关联
     * @param userId
     * @param roleIds
     */
    private void insertUserRole(Long userId, List<Long> roleIds) {
        List<UserRole> userRoleList = new ArrayList<>();
        for (Long roleId : roleIds) {
            userRoleList.add(new UserRole(userId, roleId));
        }
        userRoleMapper.batchUserRole(userRoleList);
    }

}
