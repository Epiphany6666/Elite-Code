package cn.elitecode.module.system.dal.dataobject.permission;

import io.swagger.annotations.ApiModelProperty;

/**
* system_role_menu_relation(角色和菜单关联表) | 实体类
*/
public class RoleMenuDO {

    @ApiModelProperty("角色ID")
    private Long roleId;

    @ApiModelProperty("菜单ID")
    private Long menuId;

    public RoleMenuDO() {
    }

    public RoleMenuDO(Long roleId, Long menuId) {
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
        return "RoleMenuDO{roleId = " + roleId + ", menuId = " + menuId + "}";
    }

}
