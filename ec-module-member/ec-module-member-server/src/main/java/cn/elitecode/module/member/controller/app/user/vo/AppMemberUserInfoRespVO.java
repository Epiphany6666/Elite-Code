package cn.elitecode.module.member.controller.app.user.vo;

import io.swagger.annotations.ApiModelProperty;

public class AppMemberUserInfoRespVO {
    @ApiModelProperty(value = "会员ID")
    private Long id;
    @ApiModelProperty(value = "手机号")
    private String mobile;
    @ApiModelProperty(value = "用户昵称")
    private String nickName;
    @ApiModelProperty(value = "会员头像")
    private String avatar;
    @ApiModelProperty(value = "会员性别")
    private String sex;

    public AppMemberUserInfoRespVO(Long id, String mobile, String nickName, String avatar, String sex) {
        this.id = id;
        this.mobile = mobile;
        this.nickName = nickName;
        this.avatar = avatar;
        this.sex = sex;
    }

    public AppMemberUserInfoRespVO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
