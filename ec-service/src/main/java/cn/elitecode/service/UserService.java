package cn.elitecode.service;

import cn.elitecode.common.api.CommonPage;
import cn.elitecode.model.dto.user.UserAddDTO;
import cn.elitecode.model.dto.user.UserQueryDTO;
import cn.elitecode.model.dto.user.UserUpdateDTO;
import cn.elitecode.model.entity.User;

/**
 * 用户表（user） | 业务层
 */
public interface UserService {



    /**
     * 根据条件分页获取用户信息
     * @param userQueryDTO
     * @return
     */
    CommonPage<User> selectUserList(UserQueryDTO userQueryDTO);

    /**
     * 根据id更新用户信息
     * @param userUpdateDTO
     */
    void updateUser(UserUpdateDTO userUpdateDTO);

    /**
     * 校验用户账号是否唯一
     * @param user 用户信息
     * @return 结果
     */
    boolean checkUsernameUnique(User user);

    /**
     * 新增用户
     * @param userAddDTO 用户信息
     * @return 结果
     */
    Long addUser(UserAddDTO userAddDTO);

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
     * 根据id查询用户信息
     * @param userId
     * @return
     */
    User selectUserById(Long userId);
}
