package cn.luoyan.elitecode.service;

import cn.luoyan.elitecode.model.dto.user.UserQueryDTO;
import cn.luoyan.elitecode.model.entity.User;
import cn.luoyan.elitecode.model.vo.LoginUserVO;
import cn.luoyan.elitecode.model.vo.UserVO;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 用户 业务层
 *
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
     * 用户注册
     * @param userAccount 用户账号
     * @param userPassword 用户密码
     */
    Long register(String userAccount, String userPassword);

    /**
     * 用户注销
     * @param request
     */
    void userLogout(HttpServletRequest request);

    /**
     * 根据条件分页获取用户脱敏信息
     * @param userQueryDTO
     * @return
     */
    List<UserVO> getUserVOPage(UserQueryDTO userQueryDTO);

    /**
     * 获取用户脱敏信息
     * @param user
     * @return
     */
    UserVO getUserVO(User user);

    /**
     * 获取脱敏后的用户信息
     * @param user 未脱敏的用户信息
     * @return 脱敏后的用户信息
     */
    LoginUserVO getLoginUserVO(User user);
}
