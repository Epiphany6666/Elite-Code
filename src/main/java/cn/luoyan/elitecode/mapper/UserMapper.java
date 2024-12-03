package cn.luoyan.elitecode.mapper;

import cn.luoyan.elitecode.model.entity.User;

/**
 * 用户表 数据层
 * @author 洛言
*/
public interface UserMapper {

    /**
     * 通过用户ID查询用户
     * @param userId 用户ID
     * @return 用户对象信息
     */
    public User selectUserById(Long userId);

    /**
     * 根据用户账号和密码查询用户
     * @param userAccount 用户账号
     * @param password 用户密码
     * @return
     */
    User selectUserByUserAccountAndPassword(String userAccount, String password);
}