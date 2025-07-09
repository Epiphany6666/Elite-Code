package cn.elitecode.module.resume.controller.admin.tag.vo;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotEmpty;

public class TagAddDTO {

    @ApiModelProperty(value = "标签名", required = true)
    @NotEmpty(message = "标签名不能为空")
    private String name;

    public TagAddDTO() {
    }

    public TagAddDTO(String name) {
        this.name = name;
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
        return "TagAddDTO{name = " + name + "}";
    }
}
