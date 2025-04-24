package cn.elitecode.model.dto.role;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

public class RoleUpdateDTO {

    @ApiModelProperty(value = "角色ID，主键", required = true)
    @NotNull(message = "角色id不能为空")
    private Long id;

    @ApiModelProperty("角色名称")
    private String name;

    @ApiModelProperty("显示顺序")
    private Integer sort;

    public RoleUpdateDTO() {
    }

    public RoleUpdateDTO(Long id, String name, Integer sort) {
        this.id = id;
        this.name = name;
        this.sort = sort;
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

    public String toString() {
        return "RoleUpdateDTO{id = " + id + ", name = " + name + ", sort = " + sort + "}";
    }
}
