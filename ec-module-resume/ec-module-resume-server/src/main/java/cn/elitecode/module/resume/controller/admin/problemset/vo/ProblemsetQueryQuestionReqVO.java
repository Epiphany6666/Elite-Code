package cn.elitecode.module.resume.controller.admin.problemset.vo;

import cn.elitecode.framework.common.pojo.PageRequest;
import io.swagger.annotations.ApiModelProperty;

public class ProblemsetQueryQuestionReqVO extends PageRequest {

    @ApiModelProperty("题库id")
    private Long problemsetId;

    @ApiModelProperty("题库标题")
    private String problemsetTitle;

    @ApiModelProperty("题库内容")
    private String problemsetContent;

    public ProblemsetQueryQuestionReqVO() {
    }

    public ProblemsetQueryQuestionReqVO(Long problemsetId, String problemsetTitle, String problemsetContent) {
        this.problemsetId = problemsetId;
        this.problemsetTitle = problemsetTitle;
        this.problemsetContent = problemsetContent;
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
     * @return problemsetTitle
     */
    public String getProblemsetTitle() {
        return problemsetTitle;
    }

    /**
     * 设置
     * @param problemsetTitle
     */
    public void setProblemsetTitle(String problemsetTitle) {
        this.problemsetTitle = problemsetTitle;
    }

    /**
     * 获取
     * @return problemsetContent
     */
    public String getProblemsetContent() {
        return problemsetContent;
    }

    /**
     * 设置
     * @param problemsetContent
     */
    public void setProblemsetContent(String problemsetContent) {
        this.problemsetContent = problemsetContent;
    }

    public String toString() {
        return "ProblemsetQueryQuestionReqVO{problemsetId = " + problemsetId + ", problemsetTitle = " + problemsetTitle + ", problemsetContent = " + problemsetContent + "}";
    }
}
