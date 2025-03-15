package cn.elitecode.service;

import cn.elitecode.common.PageResult;
import cn.elitecode.model.dto.user.UserQueryDTO;
import cn.elitecode.model.entity.User;
import cn.elitecode.model.bo.LoginUser;
import cn.elitecode.model.vo.UserVO;
import javax.servlet.http.HttpServletRequest;

/**
 * 用户 业务层
 *
 */
public interface UserService {

    /**
     * 用户登录
     * @param username 用户账号
     * @param userPassword 用户密码
     * @param request
     * @return 用户信息
     */
    String login(String username, String userPassword, HttpServletRequest request);

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
     * 根据id更新用户信息
     * @param user
     */
    void updateUser(User user);

    /**
     * 校验用户账号是否唯一
     * @param user 用户信息
     * @return 结果
     */
    boolean checkUsernameUnique(User user);

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

    /**
     * 修改用户头像
     * @param userId 用户ID
     * @param avatarUrl 头像地址
     */
    boolean updateUserAvatar(Long userId, String avatarUrl);

    /**
     * 根据id获取用户信息（脱敏）
     * @param userId
     * @return
     */
    UserVO getUserVOById(Long userId);

    /**
     * 获取当前登录用户
     * @return
     */
    LoginUser getLoginUser();
}
