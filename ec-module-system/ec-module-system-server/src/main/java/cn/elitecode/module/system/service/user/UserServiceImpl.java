package cn.elitecode.module.system.service.user;

import cn.elitecode.framework.common.enums.HttpStatus;
import cn.elitecode.framework.common.pojo.CommonPage;
import cn.elitecode.framework.security.core.utils.SecurityUtil;
import cn.elitecode.module.system.controller.admin.user.vo.UserAddReqVO;
import cn.elitecode.module.system.controller.admin.user.vo.UserQueryReqVO;
import cn.elitecode.module.system.controller.admin.user.vo.UserUpdateProfileReqVO;
import cn.elitecode.module.system.controller.admin.user.vo.UserUpdateReqVO;
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
 * 用户表（system_users） | 业务处理层
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public CommonPage<UserDO> selectUserList(UserQueryReqVO userQueryReqVO) {
        if (userQueryReqVO.getCurrent() != null && userQueryReqVO.getPageSize() != null) {
            userQueryReqVO.setCurrent((userQueryReqVO.getCurrent() - 1) * userQueryReqVO.getPageSize());
        }
        List<UserDO> userDOList = userMapper.selectUserList(userQueryReqVO);
        Long total = userMapper.getUserTotal(userQueryReqVO);
        CommonPage<UserDO> page = new CommonPage<>(total, userDOList);
        return page;
    }

    @Override
    @Transactional
    public void updateUser(UserUpdateReqVO userUpdateReqVO) {
        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(userUpdateReqVO, userDO);
        userDO.setUpdateBy(SecurityUtil.getUserId());
        userMapper.updateUserById(userDO);

        // 删除用户角色关联
        userRoleMapper.deleteUserRoleByUserId(userDO.getId());
        // 新增用户角色关联
        insertUserRole(userDO.getId(), userUpdateReqVO.getRoleIds());
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
    public Long addUser(UserAddReqVO userAddReqVO) {
        // 新增用户
        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(userAddReqVO, userDO);
        if (!checkUsernameUnique(userDO)) {
            throw new UsernameAlreadyExistsException(HttpStatus.PARAMS_ERROR, "新增用户 '" + userDO.getUsername() + "' 失败，账号已存在");
        }
        userDO.setCreateBy(SecurityUtil.getUserId());
        userDO.setPassword(SecurityUtil.encryptPassword(userAddReqVO.getPassword()));
        userMapper.insertUser(userDO);

        // 新增用户角色关联
        insertUserRole(userDO.getId(), userAddReqVO.getRoleIds());
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
    public void updateUserProfile(UserUpdateProfileReqVO userUpdateProfileReqVO) {
        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(userUpdateProfileReqVO, userDO);
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
        if (!roleIds.isEmpty()) {
            List<UserRoleDO> userRoleDOList = new ArrayList<>();
            for (Long roleId : roleIds) {
                userRoleDOList.add(new UserRoleDO(userId, roleId));
            }
            userRoleMapper.batchUserRole(userRoleDOList);
        }
    }

}
