package cn.elitecode.model.entity;

import io.swagger.annotations.ApiModelProperty;

/**
* user_role(用户和角色关联表) | 实体类
* @TableName
*/
public class UserRole {

    @ApiModelProperty("用户ID")
    private Long userId;

    @ApiModelProperty("角色ID")
    private Long roleId;

    public UserRole() {
    }

    public UserRole(Long userId, Long roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    /**
    * 用户ID
    */
    public void setUserId(Long userId){
    this.userId = userId;
    }

    /**
    * 角色ID
    */
    public void setRoleId(Long roleId){
    this.roleId = roleId;
    }


    /**
    * 用户ID
    */
    public Long getUserId(){
    return this.userId;
    }

    /**
    * 角色ID
    */
    public Long getRoleId(){
    return this.roleId;
    }

    public String toString() {
        return "UserRole{userId = " + userId + ", roleId = " + roleId + "}";
    }

}
