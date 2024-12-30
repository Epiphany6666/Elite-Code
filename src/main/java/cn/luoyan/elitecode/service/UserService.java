package cn.luoyan.elitecode.service;

import cn.luoyan.elitecode.common.PageResult;
import cn.luoyan.elitecode.model.dto.user.UserQueryDTO;
import cn.luoyan.elitecode.model.dto.user.UserUpdateDTO;
import cn.luoyan.elitecode.model.entity.User;
import cn.luoyan.elitecode.model.vo.LoginUserVO;
import cn.luoyan.elitecode.model.vo.UserVO;
import javax.servlet.http.HttpServletRequest;

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
     * @param user 用户信息
     */
    Long register(User user);

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
    PageResult<UserVO> getUserVOPage(UserQueryDTO userQueryDTO);

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

    /**
     * 更新用户信息
     * @param userUpdateDTO
     */
    void updateUser(UserUpdateDTO userUpdateDTO);

    /**
     * 校验用户账号是否唯一
     * @param user 用户信息
     * @return 结果
     */
    boolean checkUserAccountUnique(User user);

    /**
     * 注册用户
     * @param user 用户信息
     * @return 结果
     */
    boolean registerUser(User user);

    /**
     * 新增用户
     * @param user 用户信息
     * @return 结果
     */
    Long addUser(User user);

    /**
     * 批量删除用户
     * @param userIds 需要删除的id数组
     */
    void removeByUserIds(Long[] userIds);
}
