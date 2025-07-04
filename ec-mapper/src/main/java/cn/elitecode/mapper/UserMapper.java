package cn.elitecode.mapper;

import cn.elitecode.model.dto.user.UserQueryDTO;
import cn.elitecode.model.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 用户表 数据层
*/
@Mapper
public interface UserMapper {

    /**
     * 通过用户ID查询用户
     * @param userId 用户ID
     * @return 用户对象信息
     */
    public User selectUserById(Long userId);

    /**
     * 根据用户账号查询用户
     * @param username 用户账号
     * @return
     */
    User selectUserByUsername(String username );

    /**
     * 插入用户
     * @param user 用户信息
     * @return
     */
    int insertUser(User user);

    /**
     * 根据条件分页查询用户列表
     * @param userQueryDTO
     * @return
     */
    List<User> selectUserList(UserQueryDTO userQueryDTO);

    /**
     * 获取总条数
     * @param userQueryDTO
     * @return
     */
    Long getUserTotal(UserQueryDTO userQueryDTO);

    /**
     * 根据主键动态更新用户信息
     * @param user
     */
    void updateUserById(User user);

    /**
     * 校验用户账号是否唯一
     * @param username 用户账号
     * @return 结果
     */
    User checkUsernameUnique(String username);

    /**
     * 批量删除用户
     * @param userIds 需要删除的id数组
     * @return
     */
    int deleteUserByIds(@Param("userIds") Long[] userIds);

    /**
     * 修改用户头像
     * @param userId 用户ID
     * @param avatarUrl 头像地址
     */
    int updateAvatar(Long userId, String avatarUrl);
}
