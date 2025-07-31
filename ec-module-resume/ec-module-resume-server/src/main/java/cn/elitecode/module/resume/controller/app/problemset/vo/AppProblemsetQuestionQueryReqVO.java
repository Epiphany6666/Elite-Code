package cn.elitecode.module.resume.controller.app.problemset.vo;

import cn.elitecode.framework.common.pojo.PageRequest;
import io.swagger.annotations.ApiModelProperty;

public class AppProblemsetQuestionQueryReqVO extends PageRequest {

    @ApiModelProperty("题库id")
    private Long problemsetId;
    @ApiModelProperty("题目标题")
    private String title;

    public AppProblemsetQuestionQueryReqVO() {
    }

    public AppProblemsetQuestionQueryReqVO(Long problemsetId, String title) {
        this.problemsetId = problemsetId;
        this.title = title;
    }

    /**
     * 获取
     * @return problemsetId
     */
    public Long getProblemsetId() {
        return problemsetId;
    }

    /**
     * 设置
     * @param problemsetId
     */
    public void setProblemsetId(Long problemsetId) {
        this.problemsetId = problemsetId;
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
        return "AppProblemsetQuestionQueryReqVO{problemsetId = " + problemsetId + ", title = " + title + "}";
    }
}
