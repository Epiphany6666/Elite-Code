package cn.elitecode.module.resume.controller.admin.question.vo;

import cn.elitecode.framework.common.pojo.PageRequest;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 题目查询DTO
 */
public class QuestionQueryReqVO extends PageRequest {

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "创建者")
    private Long createBy;

    @ApiModelProperty(value = "更新者")
    private Long updateBy;

    @ApiModelProperty(value = "开始时间")
    private Date startTime;

    @ApiModelProperty(value = "结束时间")
    private Date endTime;

    public QuestionQueryReqVO() {
    }

    public QuestionQueryReqVO(String title, Long createBy, Long updateBy, Date startTime, Date endTime) {
        this.title = title;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.startTime = startTime;
        this.endTime = endTime;
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
     * @return createBy
     */
    public Long getCreateBy() {
        return createBy;
    }

    /**
     * 设置
     * @param createBy
     */
    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    /**
     * 获取
     * @return updateBy
     */
    public Long getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置
     * @param updateBy
     */
    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 获取
     * @return startTime
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 设置
     * @param startTime
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取
     * @return endTime
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 设置
     * @param endTime
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String toString() {
        return "QuestionQueryReqVO{title = " + title + ", createBy = " + createBy + ", updateBy = " + updateBy + ", startTime = " + startTime + ", endTime = " + endTime + "}";
    }
}
