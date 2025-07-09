package cn.elitecode.module.member.controller.admin.user.vo;

import cn.elitecode.framework.common.pojo.PageRequest;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class MemberUserQueryReqVO extends PageRequest {
    @ApiModelProperty(value = "手机号")
    private String mobile;
    @ApiModelProperty(value = "用户昵称")
    private String nickName;
    @ApiModelProperty(value = "会员性别")
    private String sex;
    @ApiModelProperty(value = "创建者")
    private Long createBy;
    @ApiModelProperty(value = "更新者")
    private Long updateBy;
    @ApiModelProperty(value = "开始时间")
    private Date startTime;
    @ApiModelProperty(value = "结束时间")
    private Date endTime;

    public MemberUserQueryReqVO() {
    }

    public MemberUserQueryReqVO(String mobile, String nickName, String sex, Long createBy, Long updateBy, Date startTime, Date endTime) {
        this.mobile = mobile;
        this.nickName = nickName;
        this.sex = sex;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * 获取
     * @return mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置
     * @param mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取
     * @return nickName
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 设置
     * @param nickName
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * 获取
     * @return sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置
     * @param sex
     */
    public void setSex(String sex) {
        this.sex = sex;
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
        return "MemberUserQueryReqVO{mobile = " + mobile + ", nickName = " + nickName + ", sex = " + sex + ", createBy = " + createBy + ", updateBy = " + updateBy + ", startTime = " + startTime + ", endTime = " + endTime + "}";
    }
}
