package cn.elitecode.service.impl;

import cn.elitecode.common.BaseContext;
import cn.elitecode.common.PageResult;
import cn.elitecode.common.exception.BaseException;
import cn.elitecode.common.exception.user.AdminNotAllowedException;
import cn.elitecode.common.exception.user.RegistrationFailedException;
import cn.elitecode.common.exception.user.UserNotLoggedInException;
import cn.elitecode.common.properties.JWTProperties;
import cn.elitecode.constant.HttpStatus;
import cn.elitecode.constant.UserConstant;
import cn.elitecode.mapper.UserMapper;
import cn.elitecode.model.dto.user.UserQueryDTO;
import cn.elitecode.model.entity.User;
import cn.elitecode.model.vo.LoginUser;
import cn.elitecode.model.vo.UserVO;
import cn.elitecode.service.UserService;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.signers.JWTSignerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
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

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public LoginUser login(String username, String userPassword, HttpServletRequest request) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, userPassword);
        // 该方法会去调用UserDetailsServiceImpl.loadUserByUsername，并将返回的UserDetails设置到SecurityContext中
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        if (!loginUser.isEnabled()) {
            throw new BaseException(HttpStatus.PARAMS_ERROR, "账号已被禁用");
        }
        // 生成jwt令牌
        HashMap<String, Object> claims = new HashMap<>();
        claims.put(UserConstant.LOGIN_USER_KEY, loginUser.getUsername());
        String token = JWT.create()
                .addPayloads(claims)
                .setSigner(JWTSignerUtil.hs256(JWTProperties.getSecret().getBytes()))
                // (签发时间)---------(生效时间)---------(当前时间)---------(失效时间)
                // 签发时间
                .setIssuedAt(DateUtil.date())
                // 失效时间
                .setExpiresAt(DateUtil.offsetSecond(new Date(), JWTProperties.getExpiration()))
                .sign();
        loginUser.setToken(token);
        return loginUser;
    }

    @Override
    public Long register(User user) {
        boolean regFlag = this.registerUser(user);
        if (!regFlag) {
            throw new RegistrationFailedException(HttpStatus.SYSTEM_ERROR, "注册失败");
        }
        // 若成功，返回注册用户的id
        return user.getId();
    }

    @Override
    public void userLogout(HttpServletRequest request) {
        if (getLoginUser() == null) {
            throw new UserNotLoggedInException(HttpStatus.PARAMS_ERROR, "用户未登录");
        }
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
    public void updateUser(User user) {
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
    public boolean checkUsernameUnique(User user) {
        Long userId = ObjectUtil.isNull(user.getId()) ? -1L : user.getId();
        User info = userMapper.checkUsernameUnique(user.getUsername());
        if (ObjectUtil.isNotNull(info) && info.getId().longValue() != userId.longValue()) {
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
        return user.getId();
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
        int result = userMapper.updateAvatar(userId, avatarUrl);
        if (result <= 0) {
            log.error("修改用户头像失败：{}", result);
            return false;
        }
        return true;
    }

    @Override
    public UserVO getUserVOById(Long userId) {
        User user = userMapper.selectUserById(userId);
        return getUserVO(user);
    }

    public LoginUser getLoginUser() {
        LoginUser loginUser = (LoginUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return loginUser;
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
