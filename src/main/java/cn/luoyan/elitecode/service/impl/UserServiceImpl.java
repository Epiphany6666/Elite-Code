package cn.luoyan.elitecode.service.impl;

import cn.luoyan.elitecode.common.constant.HttpStatus;
import cn.luoyan.elitecode.common.exception.user.UserAccountNotFoundException;
import cn.luoyan.elitecode.common.exception.user.UserPasswordNotMatchException;
import cn.luoyan.elitecode.mapper.UserMapper;
import cn.luoyan.elitecode.model.entity.User;
import cn.luoyan.elitecode.model.vo.LoginUserVO;
import cn.luoyan.elitecode.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户 处理层
 *
 * @author 洛言
 */
@Service
public class UserServiceImpl implements UserService {

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
        request.getSession().setAttribute("user_login", user);

        // 返回用户信息
        return getLoginUserVO(user);
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
}
