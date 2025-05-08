package cn.elitecode.model.dto.role;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class RoleAddDTO {

    @ApiModelProperty(value = "角色名称", required = true)
    @NotEmpty(message = "角色名称不能为空")
    private String name;

    @ApiModelProperty(value = "显示顺序", required = true)
    @NotNull(message = "显示顺序不能为空")
    private Integer sort;

    @ApiModelProperty("菜单树选择项是否关联显示（ 0：父子不互相关联显示 1：父子互相关联显示）")
    private boolean menuCheckStrictly;

    @ApiModelProperty("菜单id列表")
    private List<Long> menuIds;

    public RoleAddDTO() {
    }

    public RoleAddDTO(String name, Integer sort, boolean menuCheckStrictly, List<Long> menuIds) {
        this.name = name;
        this.sort = sort;
        this.menuCheckStrictly = menuCheckStrictly;
        this.menuIds = menuIds;
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
        return "RoleAddDTO{name = " + name + ", sort = " + sort + ", menuCheckStrictly = " + menuCheckStrictly + ", menuIds = " + menuIds + "}";
    }
}
