package cn.elitecode.module.system.controller.admin.permmision.vo.resourcecategory;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ResourceCategoryAddReqVO {

    @ApiModelProperty(value="分类名称", required = true)
    @NotEmpty(message = "分类名称不能为空")
    private String name;

    @ApiModelProperty(value="排序", required = true)
    @NotNull(message = "排序不能为空")
    private Integer sort;

    public ResourceCategoryAddReqVO() {
    }

    public ResourceCategoryAddReqVO(String name, Integer sort) {
        this.name = name;
        this.sort = sort;
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
        return "ResourceCategoryAddReqVO{name = " + name + ", sort = " + sort + "}";
    }
}
