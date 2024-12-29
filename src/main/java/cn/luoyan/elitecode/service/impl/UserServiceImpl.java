package cn.luoyan.elitecode.service.impl;

import cn.luoyan.elitecode.common.BaseContext;
import cn.luoyan.elitecode.common.PageResult;
import cn.luoyan.elitecode.common.constant.HttpStatus;
import cn.luoyan.elitecode.common.exception.user.*;
import cn.luoyan.elitecode.mapper.UserMapper;
import cn.luoyan.elitecode.model.dto.user.UserQueryDTO;
import cn.luoyan.elitecode.model.dto.user.UserUpdateDTO;
import cn.luoyan.elitecode.model.entity.User;
import cn.luoyan.elitecode.model.vo.LoginUserVO;
import cn.luoyan.elitecode.model.vo.UserVO;
import cn.luoyan.elitecode.service.UserService;
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
 *
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    private static final String USER_LOGIN_STATE = "user_login";

    @Autowired
    private UserMapper userMapper;

    private final static String SALT = "luoyan";

    @Override
    public LoginUserVO login(String userAccount, String userPassword, HttpServletRequest request) {
        // 查询用户是否存在
        User user = userMapper.selectUserByUserAccount(userAccount);
        if (user == null) {
            throw new UserAccountNotFoundException(HttpStatus.PARAMS_ERROR, "账号不存在");
        }
        String encryptPassword = DigestUtils.md5DigestAsHex((SALT + userPassword).getBytes());
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
    public Long register(String userAccount, String userPassword) {
        // 查询用户是否存在
        User user = userMapper.selectUserByUserAccount(userAccount);
        if (user != null) {
            throw new UserAccountAlreadyExistsException(HttpStatus.PARAMS_ERROR, "账号已存在");
        }

        // 加密
        String encryptPassword = DigestUtils.md5DigestAsHex(userPassword.getBytes());

        // 插入数据库
        user = new User();
        user.setUserAccount(userAccount);
        user.setUserPassword(encryptPassword);
        int result = userMapper.insertUser(user);

        if (result <= 0) {
            log.error("用户插入数据库失败：{}", result);
            throw new RegistrationFailedException(HttpStatus.SYSTEM_ERROR, "注册失败");
        }
        // 返回插入用户的id
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
}
