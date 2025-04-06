package cn.elitecode.model.entity;

import io.swagger.annotations.ApiModelProperty;

/**
* role_menu(角色和菜单关联表) | 实体类
*/
public class RoleMenu {

    @ApiModelProperty("角色ID")
    private Long roleId;

    @ApiModelProperty("菜单ID")
    private Long menuId;

    public RoleMenu() {
    }

    public RoleMenu(Long roleId, Long menuId) {
        this.roleId = roleId;
        this.menuId = menuId;
    }

    /**
    * 角色ID
    */
    public void setRoleId(Long roleId){
    this.roleId = roleId;
    }

    /**
    * 菜单ID
    */
    public void setMenuId(Long menuId){
    this.menuId = menuId;
    }


    /**
    * 角色ID
    */
    public Long getRoleId(){
    return this.roleId;
    }

    /**
    * 菜单ID
    */
    public Long getMenuId(){
    return this.menuId;
    }

    public String toString() {
        return "RoleMenu{roleId = " + roleId + ", menuId = " + menuId + "}";
    }

}
