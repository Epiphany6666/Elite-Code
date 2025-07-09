package cn.elitecode.module.system.service.user;

import cn.elitecode.framework.common.pojo.CommonPage;
import cn.elitecode.module.system.controller.admin.user.vo.UserAddDTO;
import cn.elitecode.module.system.controller.admin.user.vo.UserQueryDTO;
import cn.elitecode.module.system.controller.admin.user.vo.UserUpdateDTO;
import cn.elitecode.module.system.controller.admin.user.vo.UserUpdateProfileDto;
import cn.elitecode.module.system.dal.dataobject.user.UserDO;

/**
 * 用户表（user） | 业务层
 */
public interface UserService {
    
    /**
     * 根据条件分页获取用户信息
     * @param userQueryDTO
     * @return
     */
    CommonPage<UserDO> selectUserList(UserQueryDTO userQueryDTO);

    /**
     * 根据id更新用户信息
     * @param userUpdateDTO
     */
    void updateUser(UserUpdateDTO userUpdateDTO);

    /**
     * 校验用户账号是否唯一
     * @param userDO 用户信息
     * @return 结果
     */
    boolean checkUsernameUnique(UserDO userDO);

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
    UserDO selectUserById(Long userId);

    /**
     * 更改个人信息
     * @param userUpdateProfileDto
     */
    void updateUserProfile(UserUpdateProfileDto userUpdateProfileDto);
}
