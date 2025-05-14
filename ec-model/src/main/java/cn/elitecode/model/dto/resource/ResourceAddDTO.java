package cn.elitecode.model.dto.resource;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ResourceAddDTO {

    @ApiModelProperty(value="资源名称", required = true)
    @NotEmpty(message = "资源名称不能为空")
    private String name;

    @ApiModelProperty(value="资源URL", required = true)
    @NotEmpty(message = "资源URL不能为空")
    private String url;

    @ApiModelProperty(value="分类ID", required = true)
    @NotNull(message = "分类ID不能为空")
    private Long categoryId;

    public ResourceAddDTO() {
    }

    public ResourceAddDTO(String name, String url, Long categoryId) {
        this.name = name;
        this.url = url;
        this.categoryId = categoryId;
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
        return "ResourceAddDTO{name = " + name + ", url = " + url + ", categoryId = " + categoryId + "}";
    }
}
