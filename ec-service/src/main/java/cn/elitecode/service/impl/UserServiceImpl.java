package cn.elitecode.service.impl;

import cn.elitecode.common.BaseContext;
import cn.elitecode.common.PageResult;
import cn.elitecode.common.exception.user.*;
import cn.elitecode.constant.HttpStatus;
import cn.elitecode.constant.UserConstant;
import cn.elitecode.mapper.UserMapper;
import cn.elitecode.model.dto.user.UserQueryDTO;
import cn.elitecode.model.dto.user.UserUpdateDTO;
import cn.elitecode.model.entity.User;
import cn.elitecode.model.vo.LoginUserVO;
import cn.elitecode.model.vo.UserVO;
import cn.elitecode.service.UserService;
import cn.hutool.core.util.ObjectUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户 处理层
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    private static final String USER_LOGIN_STATE = "user_login";

    @Autowired
    private UserMapper userMapper;

    @Override
    public LoginUserVO login(String userAccount, String userPassword, HttpServletRequest request) {
        // 查询用户是否存在
        User user = userMapper.selectUserByUserAccount(userAccount);
        if (user == null) {
            throw new UserAccountNotFoundException(HttpStatus.PARAMS_ERROR, "账号不存在");
        }
        String encryptPassword = DigestUtils.md5DigestAsHex((UserConstant.SALT + userPassword).getBytes());
        if (!encryptPassword.equals(user.getUserPassword())) {
            throw new UserPasswordNotMatchException(HttpStatus.PARAMS_ERROR, "密码错误");
        }

        // 设置登录态
        request.getSession().setAttribute(USER_LOGIN_STATE, user);
        BaseContext.setCurrentId(user.getUserId());

        // 返回用户信息
        return getLoginUserVO(user);
    }

    @Override
    public Long register(User user) {
        boolean regFlag = this.registerUser(user);
        if (!regFlag) {
            throw new RegistrationFailedException(HttpStatus.SYSTEM_ERROR, "注册失败");
        }
        // 若成功，返回注册用户的id
        return user.getUserId();
    }

    @Override
    public void userLogout(HttpServletRequest request) {
        if (request.getSession().getAttribute(USER_LOGIN_STATE) == null) {
            throw new UserNotLoggedInException(500, "用户未登录");
        }
        request.getSession().removeAttribute(USER_LOGIN_STATE);
    }

    @Override
    public PageResult<UserVO> getUserVOPage(UserQueryDTO userQueryDTO) {
        if (userQueryDTO.getCurrent() != null && userQueryDTO.getPageSize() != null) {
            userQueryDTO.setCurrent((userQueryDTO.getCurrent() - 1) * userQueryDTO.getPageSize());
        }
        List<User> userList = userMapper.getUserByPage(userQueryDTO);
        List<UserVO> userVOList = userList.stream().map(item -> getUserVO(item)).collect(Collectors.toList());
        Long total = userMapper.getTotal(userQueryDTO);
        PageResult<UserVO> pageResult = new PageResult<>();
        pageResult.setData(userVOList);
        pageResult.setTotal(total);
        return pageResult;
    }

    @Override
    public UserVO getUserVO(User user) {
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        return userVO;
    }


    @Override
    public LoginUserVO getLoginUserVO(User user) {
        if (user == null) {
            return null;
        }

        // 脱敏
        LoginUserVO loginUserVO = new LoginUserVO();
        BeanUtils.copyProperties(user, loginUserVO);
        return loginUserVO;
    }

    @Override
    public void updateUser(UserUpdateDTO userUpdateDTO) {
        User user = new User();
        BeanUtils.copyProperties(userUpdateDTO, user);
        user.setUpdateBy(BaseContext.getCurrentId());
        userMapper.updateByPrimaryKeySelective(user);
    }

    /**
     * 校验用户账号是否唯一
     *
     * @param user 用户信息
     * @return 结果
     */
    @Override
    public boolean checkUserAccountUnique(User user) {
        Long userId = ObjectUtil.isNull(user.getUserId()) ? -1L : user.getUserId();
        User info = userMapper.checkUserAccountUnique(user.getUserAccount());
        if (ObjectUtil.isNotNull(info) && info.getUserId().longValue() != userId.longValue()) {
            return UserConstant.NOT_UNIQUE;
        }
        return UserConstant.UNIQUE;
    }

    @Override
    public boolean registerUser(User user) {
        int result = userMapper.insertUser(user);
        if (result <= 0) {
            log.error("用户插入数据库失败：{}", result);
        }
        return true;
    }

    /**
     * 新增用户
     * @param user 用户信息
     * @return 结果
     */
    @Override
    public Long addUser(User user) {
        int result = userMapper.insertUser(user);
        if (result <= 0) {
            log.error("用户插入数据库失败：{}", result);
        }
        return user.getUserId();
    }

    /**
     * 批量删除用户
     * @param userIds 需要删除的id数组
     */
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

    /**
     * 修改用户头像
     * @param userId 用户ID
     * @param avatarUrl 头像地址
     */
    @Override
    public boolean updateUserAvatar(Long userId, String avatarUrl) {
        int result = userMapper.updateUserAvatar(userId, avatarUrl);
        if (result <= 0) {
            log.error("修改用户头像失败：{}", result);
            return false;
        }
        return true;
    }

    private void checkUserAllowed(User user) {
        if (ObjectUtil.isNotNull(user.getUserId()) && isAdmin(user.getUserId())) {
            throw new AdminNotAllowedException(HttpStatus.ADMIN_NOT_ALLOWED_ERROR, "不允许操作超级管理员用户");
        }
    }

    private boolean isAdmin(Long userId) {
        List<Long> adminUserIds = userMapper.selectAdminUserIds();
        return adminUserIds.contains(userId);
    }
}
