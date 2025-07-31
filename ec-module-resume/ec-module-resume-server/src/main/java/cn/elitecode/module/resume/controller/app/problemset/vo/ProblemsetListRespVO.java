package cn.elitecode.module.resume.controller.app.problemset.vo;

import io.swagger.annotations.ApiModelProperty;

public class ProblemsetListRespVO {
    @ApiModelProperty("用户ID，主键")
    private Long id;

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("图片")
    private String picture;

    public ProblemsetListRespVO() {
    }

    public ProblemsetListRespVO(Long id, String title, String description, String picture) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.picture = picture;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
