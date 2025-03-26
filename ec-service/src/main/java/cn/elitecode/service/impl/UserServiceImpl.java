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
 * 用户 处理层
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public CommonResult<CommonPage<User>> getUserPage(UserQueryDTO userQueryDTO) {
        if (userQueryDTO.getCurrent() != null && userQueryDTO.getPageSize() != null) {
            userQueryDTO.setCurrent((userQueryDTO.getCurrent() - 1) * userQueryDTO.getPageSize());
        }
        List<User> userList = userMapper.getUserByPage(userQueryDTO);
        Long total = userMapper.getTotal(userQueryDTO);
        CommonPage<User> page = new CommonPage<>(total, userList);
        return CommonResult.success(page);
    }

    @Override
    public void updateUser(User user) {
        user.setUpdateBy(BaseContext.getCurrentId());
        userMapper.updateByPrimaryKeySelective(user);
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
        int result = userMapper.insertUser(user);
        if (result <= 0) {
            log.error("用户插入数据库失败：{}", result);
        }
        return user.getId();
    }

    @Override
    public void removeByUserIds(Long[] userIds) {
        for (Long userId : userIds) {
            checkUserAllowed(new User(userId));
        }
        int result = userMapper.deleteUserByIds(userIds);
        if (result <= 0) {
            log.error("批量删除用户失败：{}", result);
        }
    }

    @Override
    public boolean updateUserAvatar(Long userId, String avatarUrl) {
        int result = userMapper.updateAvatar(userId, avatarUrl);
        if (result <= 0) {
            log.error("修改用户头像失败：{}", result);
            return false;
        }
        return true;
    }

    private void checkUserAllowed(User user) {
        if (ObjectUtil.isNotNull(user.getId()) && isAdmin(user.getId())) {
            throw new AdminNotAllowedException(HttpStatus.ADMIN_NOT_ALLOWED_ERROR, "不允许操作超级管理员用户");
        }
    }

    private boolean isAdmin(Long userId) {
        List<Long> adminUserIds = userMapper.selectAdminIds();
        return adminUserIds.contains(userId);
    }

}
