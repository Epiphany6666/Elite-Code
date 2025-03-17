package cn.elitecode.model.dto.user;

import io.swagger.annotations.ApiModelProperty;

public class UserUpdateProfileDto {

    @ApiModelProperty(value = "账号")
    private String username;

    @ApiModelProperty(value = "用户昵称")
    private String nickName;

    @ApiModelProperty(value = "用户简介")
    private String profile;

    public UserUpdateProfileDto() {
    }

    public UserUpdateProfileDto(String username, String nickName, String profile) {
        this.username = username;
        this.nickName = nickName;
        this.profile = profile;
    }

    /**
     * 获取
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
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
     * @return profile
     */
    public String getProfile() {
        return profile;
    }

    /**
     * 设置
     * @param profile
     */
    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String toString() {
        return "UserUpdateProfileDto{username = " + username + ", nickName = " + nickName + ", profile = " + profile + "}";
    }

}
