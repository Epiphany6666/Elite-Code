package cn.elitecode.module.resume.controller.admin.problemset.vo;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotEmpty;

public class ProblemsetAddReqVO {

    @ApiModelProperty(value = "标题", required = true)
    @NotEmpty(message = "标题不能为空")
    private String title;

    @ApiModelProperty(value = "描述")
    private String description;

    public ProblemsetAddReqVO() {
    }

    public ProblemsetAddReqVO(String title, String description) {
        this.title = title;
        this.description = description;
    }

    /**
     * 获取
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return "ProblemsetAddReqVO{title = " + title + ", description = " + description + "}";
    }

}
