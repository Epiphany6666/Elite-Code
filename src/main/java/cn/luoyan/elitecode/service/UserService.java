package cn.luoyan.elitecode.service;

import cn.luoyan.elitecode.model.entity.User;
import cn.luoyan.elitecode.model.vo.LoginUserVO;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户 业务层
 *
 * @author 洛言
 */
public interface UserService {

    /**
     * 用户登录
     * @param userAccount 用户账号
     * @param userPassword 用户密码
     * @param request
     * @return 用户信息
     */
    LoginUserVO login(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * 获取脱敏后的用户信息
     * @param user 未脱敏的用户信息
     * @return 脱敏后的用户信息
     */
    LoginUserVO getLoginUserVO(User user);
}
