package cn.elitecode.model.dto.user;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public class UserUpdateDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -7748132921047099038L;

    /**
     * 用户ID
     */
    private Long id;

    /**
     * 账号
     */
    private String account;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 用户简介
     */
    private String profile;

    /**
     * 用户角色：user/admin/ban
     */
    private List<String> roles;

    public UserUpdateDTO() {
    }

    public UserUpdateDTO(Long id, String account, String nickName, String profile, List<String> roles) {
        this.id = id;
        this.account = account;
        this.nickName = nickName;
        this.profile = profile;
        this.roles = roles;
    }

    /**
     * 获取
     * @return userId
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
     * @return userAccount
     */
    public String getAccount() {
        return account;
    }

    /**
     * 设置
     * @param account
     */
    public void setAccount(String account) {
        this.account = account;
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
     * @return userProfile
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
     * @return userRoles
     */
    public List<String> getRoles() {
        return roles;
    }

    /**
     * 设置
     * @param roles
     */
    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String toString() {
        return "UserUpdateDTO{userId = " + id + ", userAccount = " + account + ", nickName = " + nickName + ", userProfile = " + profile + ", userRoles = " + roles + "}";
    }
}
