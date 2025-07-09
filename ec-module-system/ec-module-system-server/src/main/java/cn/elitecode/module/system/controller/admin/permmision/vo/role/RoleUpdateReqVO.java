package cn.elitecode.module.system.controller.admin.permmision.vo.role;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class RoleUpdateReqVO {

    @ApiModelProperty(value = "角色ID，主键", required = true)
    @NotNull(message = "角色id不能为空")
    private Long id;

    @ApiModelProperty("角色名称")
    private String name;

    @ApiModelProperty("显示顺序")
    private Integer sort;

    @ApiModelProperty("菜单树选择项是否关联（ 0：父子不互相关联显示 1：父子互相关联显示）")
    private boolean menuCheckStrictly;

    @ApiModelProperty("菜单id列表")
    private List<Long> menuIds;

    public RoleUpdateReqVO() {
    }

    public RoleUpdateReqVO(Long id, String name, Integer sort, boolean menuCheckStrictly, List<Long> menuIds) {
        this.id = id;
        this.name = name;
        this.sort = sort;
        this.menuCheckStrictly = menuCheckStrictly;
        this.menuIds = menuIds;
    }

    /**
     * 获取
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return sort
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置
     * @param sort
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取
     * @return menuCheckStrictly
     */
    public Boolean getMenuCheckStrictly() {
        return menuCheckStrictly;
    }

    /**
     * 设置
     * @param menuCheckStrictly
     */
    public void setMenuCheckStrictly(boolean menuCheckStrictly) {
        this.menuCheckStrictly = menuCheckStrictly;
    }

    /**
     * 获取
     * @return menuIds
     */
    public List<Long> getMenuIds() {
        return menuIds;
    }

    /**
     * 设置
     * @param menuIds
     */
    public void setMenuIds(List<Long> menuIds) {
        this.menuIds = menuIds;
    }

    public String toString() {
        return "RoleUpdateReqVO{id = " + id + ", name = " + name + ", sort = " + sort + ", menuCheckStrictly = " + menuCheckStrictly + ", menuIds = " + menuIds + "}";
    }
}
