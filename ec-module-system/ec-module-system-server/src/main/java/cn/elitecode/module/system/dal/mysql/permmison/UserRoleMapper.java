package cn.elitecode.module.system.dal.mysql.permmison;

import cn.elitecode.module.system.dal.dataobject.permission.UserRoleDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* user_role(用户和角色关联表)
*/
@Mapper
public interface UserRoleMapper {

    /**
     * 批量新增用户角色信息
     * @param userRoleDOList
     */
    void batchUserRole(@Param("userRoleDOList") List<UserRoleDO> userRoleDOList);

    /**
     * 根据 用户id 删除用户角色关联
     * @param userId
     */
    void deleteUserRoleByUserId(Long userId);

    /**
     * 根据 用户id数组 删除用户角色关联
     * @param userIds
     */
    void deleteUserRoleByUserIds(@Param("userIds") Long[] userIds);

    /**
     * 通过角色id查询用户角色数量
     * @param roleId
     * @return
     */
    int countUserRoleByRoleId(Long roleId);
}




