package cn.elitecode.module.resume.controller.app.problemset.vo;

import io.swagger.annotations.ApiModelProperty;

public class AppProblemsetQuestionQueryRespVO {

    @ApiModelProperty("题目ID，主键")
    private Long id;
    @ApiModelProperty("标题")
    private String title;

    public AppProblemsetQuestionQueryRespVO() {
    }

    public AppProblemsetQuestionQueryRespVO(Long id, String title) {
        this.id = id;
        this.title = title;
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

    public String toString() {
        return "AppProblemsetQuestionQueryRespVO{id = " + id + ", title = " + title + "}";
    }
}
