package cn.elitecode.module.member.controller.admin.user.vo;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

public class MemberUserUpdateReqVO {
    @ApiModelProperty(value = "会员ID", required = true)
    @NotNull(message = "会员id不能为空")
    private Long id;
    @ApiModelProperty(value = "手机号")
    private String mobile;
    @ApiModelProperty(value = "用户昵称")
    private String nickName;
    @ApiModelProperty(value = "会员头像")
    private String avatar;
    @ApiModelProperty(value = "会员性别")
    private String sex;

    public MemberUserUpdateReqVO() {
    }

    public MemberUserUpdateReqVO(Long id, String mobile, String nickName, String avatar, String sex) {
        this.id = id;
        this.mobile = mobile;
        this.nickName = nickName;
        this.avatar = avatar;
        this.sex = sex;
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
     * @return avatar
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * 设置
     * @param avatar
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
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

    public String toString() {
        return "MemberUserUpdateReqVO{id = " + id + ", mobile = " + mobile + ", nickName = " + nickName + ", avatar = " + avatar + ", sex = " + sex + "}";
    }
}
