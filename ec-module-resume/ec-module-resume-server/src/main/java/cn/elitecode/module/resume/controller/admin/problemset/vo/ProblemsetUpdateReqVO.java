package cn.elitecode.module.resume.controller.admin.problemset.vo;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

public class ProblemsetUpdateReqVO {

    @ApiModelProperty(value = "用户ID，主键", required = true)
    @NotNull(message = "id不能为空")
    private Long id;

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("描述")
    private String description;

    public ProblemsetUpdateReqVO() {
    }

    public ProblemsetUpdateReqVO(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
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
        return "ProblemsetUpdateReqVO{id = " + id + ", title = " + title + ", description = " + description + "}";
    }

}
