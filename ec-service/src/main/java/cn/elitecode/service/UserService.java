package cn.elitecode.service;

import cn.elitecode.common.PageResult;
import cn.elitecode.model.dto.user.UserQueryDTO;
import cn.elitecode.model.entity.User;

/**
 * 用户 业务层
 *
 */
public interface UserService {



    /**
     * 根据条件分页获取用户信息
     * @param userQueryDTO
     * @return
     */
    PageResult<User> getUserPage(UserQueryDTO userQueryDTO);

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

}
