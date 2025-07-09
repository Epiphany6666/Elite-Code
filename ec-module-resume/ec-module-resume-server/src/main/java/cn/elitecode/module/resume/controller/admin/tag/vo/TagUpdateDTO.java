package cn.elitecode.module.resume.controller.admin.tag.vo;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

public class TagUpdateDTO {

    @ApiModelProperty(value = "标签ID，主键", required = true)
    @NotNull(message = "id不能为空")
    private Long id;

    @ApiModelProperty("标签名")
    private String name;

    public TagUpdateDTO() {
    }

    public TagUpdateDTO(Long id, String name) {
        this.id = id;
        this.name = name;
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

    public String toString() {
        return "TagUpdateDTO{id = " + id + ", name = " + name + "}";
    }
}
