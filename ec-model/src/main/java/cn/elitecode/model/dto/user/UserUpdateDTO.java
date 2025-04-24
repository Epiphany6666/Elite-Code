package cn.elitecode.model.dto.user;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class UserUpdateDTO {

    @ApiModelProperty(value = "用户ID", required = true)
    @NotNull(message = "用户ID不能为空")
    private Long id;

    @ApiModelProperty(value = "账号")
    private String username;

    @ApiModelProperty(value = "用户昵称")
    private String nickName;

    @ApiModelProperty(value = "用户头像")
    private String avatar;

    @ApiModelProperty(value = "用户简介")
    private String profile;

    @ApiModelProperty(value = "用户角色id列表")
    private List<Long> roleIds;

    public UserUpdateDTO() {
    }

    public UserUpdateDTO(Long id, String username, String nickName, String avatar, String profile, List<Long> roleIds) {
        this.id = id;
        this.username = username;
        this.nickName = nickName;
        this.avatar = avatar;
        this.profile = profile;
        this.roleIds = roleIds;
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

    /**
     * 获取
     * @return roleIds
     */
    public List<Long> getRoleIds() {
        return roleIds;
    }

    /**
     * 设置
     * @param roleIds
     */
    public void setRoleIds(List<Long> roleIds) {
        this.roleIds = roleIds;
    }

    public String toString() {
        return "UserUpdateDTO{id = " + id + ", username = " + username + ", nickName = " + nickName + ", avatar = " + avatar + ", profile = " + profile + ", roleIds = " + roleIds + "}";
    }
}
