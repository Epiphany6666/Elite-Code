package cn.elitecode.module.system.controller.admin.permmision.vo.resource;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

public class ResourceUpdateReqVO {

    @ApiModelProperty(value="资源ID", required = true)
    @NotNull(message = "资源id不能为空")
    private Long id;

    @ApiModelProperty(value="资源名称")
    private String name;

    @ApiModelProperty(value="资源URL")
    private String url;

    @ApiModelProperty(value="分类ID")
    private Long categoryId;

    public ResourceUpdateReqVO() {
    }

    public ResourceUpdateReqVO(Long id, String name, String url, Long categoryId) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.categoryId = categoryId;
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
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取
     * @return categoryId
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * 设置
     * @param categoryId
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String toString() {
        return "ResourceUpdateReqVO{id = " + id + ", name = " + name + ", url = " + url + ", categoryId = " + categoryId + "}";
    }
}
