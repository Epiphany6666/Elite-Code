package cn.elitecode.module.system.dal.dataobject.permission;

import io.swagger.annotations.ApiModelProperty;

public class RoleResourceDO {

    @ApiModelProperty(value="角色ID")
    private Long roleId;

    @ApiModelProperty(value="资源ID")
    private Long resourceId;

    public RoleResourceDO() {
    }

    public RoleResourceDO(Long roleId, Long resourceId) {
        this.roleId = roleId;
        this.resourceId = resourceId;
    }

    /**
     * 获取
     * @return roleId
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * 设置
     * @param roleId
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取
     * @return resourceId
     */
    public Long getResourceId() {
        return resourceId;
    }

    /**
     * 设置
     * @param resourceId
     */
    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public String toString() {
        return "RoleResourceDO{roleId = " + roleId + ", resourceId = " + resourceId + "}";
    }
}
