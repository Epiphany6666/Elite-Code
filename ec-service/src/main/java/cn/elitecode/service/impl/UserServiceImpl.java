package cn.elitecode.service.impl;

import cn.elitecode.common.BaseContext;
import cn.elitecode.common.api.CommonPage;
import cn.elitecode.common.api.CommonResult;
import cn.elitecode.common.exception.user.AdminNotAllowedException;
import cn.elitecode.constant.HttpStatus;
import cn.elitecode.constant.UserConstant;
import cn.elitecode.mapper.UserMapper;
import cn.elitecode.model.dto.user.UserQueryDTO;
import cn.elitecode.model.entity.User;
import cn.elitecode.service.UserService;
import cn.hutool.core.util.ObjectUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * 用户表（user） | 业务处理层
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public CommonResult<CommonPage<User>> selectUserList(UserQueryDTO userQueryDTO) {
        if (userQueryDTO.getCurrent() != null && userQueryDTO.getPageSize() != null) {
            userQueryDTO.setCurrent((userQueryDTO.getCurrent() - 1) * userQueryDTO.getPageSize());
        }
        List<User> userList = userMapper.selectUserList(userQueryDTO);
        Long total = userMapper.getUserTotal(userQueryDTO);
        CommonPage<User> page = new CommonPage<>(total, userList);
        return CommonResult.success(page);
    }

    @Override
    public void updateUser(User user) {
        user.setUpdateBy(BaseContext.getCurrentId());
        userMapper.updateUserById(user);
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
    public Long addUser(User user) {
        userMapper.insertUser(user);
        return user.getId();
    }

    @Override
    public void removeByUserIds(Long[] userIds) {
        for (Long userId : userIds) {
            checkUserAllowed(new User(userId));
        }
        userMapper.deleteUserByIds(userIds);
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

}
