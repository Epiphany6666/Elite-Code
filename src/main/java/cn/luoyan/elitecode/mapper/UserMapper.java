package cn.luoyan.elitecode.mapper;

import cn.luoyan.elitecode.model.dto.user.UserQueryDTO;
import cn.luoyan.elitecode.model.entity.User;
import java.util.List;

/**
 * 用户表 数据层
*/
public interface UserMapper {

    /**
     * 通过用户ID查询用户
     * @param userId 用户ID
     * @return 用户对象信息
     */
    public User selectUserById(Long userId);

    /**
     * 根据用户账号查询用户
     * @param userAccount 用户账号
     * @return
     */
    User selectUserByUserAccount(String userAccount );

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
    List<User> getUserByPage(UserQueryDTO userQueryDTO);

    /**
     * 获取总条数
     * @param userQueryDTO
     * @return
     */
    Long getTotal(UserQueryDTO userQueryDTO);

    /**
     * 根据主键动态更新用户信息
     * <p>该方法会根据传入的 Employee 对象中的非空字段进行更新操作，
     * 只有非空字段才会被更新到数据库对应的表中。</p>
     * @param user
     */
    void updateByPrimaryKeySelective(User user);

    /**
     * 校验用户账号是否唯一
     * @param userAccount 用户账号
     * @return 结果
     */
    User checkUserAccountUnique(String userAccount);
}
