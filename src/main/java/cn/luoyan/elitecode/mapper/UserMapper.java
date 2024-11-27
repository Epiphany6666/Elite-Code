package cn.luoyan.elitecode.mapper;

import cn.luoyan.elitecode.model.entity.SysUser;

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
    public SysUser selectUserById(Long userId);
}
