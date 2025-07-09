package cn.elitecode.module.system.controller.admin.permmision.vo.resourcecategory;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

public class ResourceCategoryUpdateReqVO {

    @ApiModelProperty(value="分类ID", required = true)
    @NotNull(message = "分类id不能为空")
    private Long id;

    @ApiModelProperty(value="分类名称")
    private String name;

    @ApiModelProperty(value="排序")
    private Integer sort;

    public ResourceCategoryUpdateReqVO() {
    }

    public ResourceCategoryUpdateReqVO(Long id, String name, Integer sort) {
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
        return "ResourceCategoryUpdateReqVO{id = " + id + ", name = " + name + ", sort = " + sort + "}";
    }
}
