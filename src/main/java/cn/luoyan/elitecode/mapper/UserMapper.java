package cn.luoyan.elitecode.mapper;

import cn.luoyan.elitecode.model.entity.SysUser;

/**
* @author 52837
* @description 针对表【sys_user(用户信息表)】的数据库操作Mapper
* @createDate 2024-11-27 16:39:31
* @Entity cn.luoyan.elitecode.model.entity.SysUser
*/
public interface UserMapper {

    /**
     * 通过用户ID查询用户
     * @param userId 用户ID
     * @return 用户对象信息
     */
    public SysUser selectUserById(Long userId);
}
