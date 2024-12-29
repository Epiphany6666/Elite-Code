package cn.luoyan.elitecode.model.dto.user;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public class UserUpdateDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -7748132921047099038L;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 账号
     */
    private String userAccount;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 用户简介
     */
    private String userProfile;

    /**
     * 用户角色：user/admin/ban
     */
    private List<String> userRoles;

    public UserUpdateDTO() {
    }

    public UserUpdateDTO(Long userId, String userAccount, String nickName, String userProfile, List<String> userRoles) {
        this.userId = userId;
        this.userAccount = userAccount;
        this.nickName = nickName;
        this.userProfile = userProfile;
        this.userRoles = userRoles;
    }

    /**
     * 获取
     * @return userId
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置
     * @param userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取
     * @return userAccount
     */
    public String getUserAccount() {
        return userAccount;
    }

    /**
     * 设置
     * @param userAccount
     */
    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
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
    public String getUserProfile() {
        return userProfile;
    }

    /**
     * 设置
     * @param userProfile
     */
    public void setUserProfile(String userProfile) {
        this.userProfile = userProfile;
    }

    /**
     * 获取
     * @return userRoles
     */
    public List<String> getUserRoles() {
        return userRoles;
    }

    /**
     * 设置
     * @param userRoles
     */
    public void setUserRoles(List<String> userRoles) {
        this.userRoles = userRoles;
    }

    public String toString() {
        return "UserUpdateDTO{userId = " + userId + ", userAccount = " + userAccount + ", nickName = " + nickName + ", userProfile = " + userProfile + ", userRoles = " + userRoles + "}";
    }
}
