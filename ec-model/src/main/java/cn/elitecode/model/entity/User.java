package cn.elitecode.model.entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 用户实体类
 * @TableName sys_user
 */
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = -6603178573463538791L;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 账号（唯一）
     */
    private String userAccount;

    /**
     * 密码
     */
    private String userPassword;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 用户头像
     */
    private String userAvatar;

    /**
     * 用户简介
     */
    private String userProfile;

    /**
     * 用户角色：user/admin/ban
     */
    private List<String> userRoles;

    /**
     * 删除标志（0代表存在，2代表删除）
     */
    private String delFlag;

    /**
     * 创建者
     */
    private Long createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新者
     */
    private Long updateBy;

    /**
     * 编辑时间
     */
    private Date updateTime;

    public User(Long userId) {
        this.userId = userId;
    }

    public User() {
    }

    public User(Long userId, String userAccount, String userPassword, String nickName, String userAvatar, String userProfile, List<String> userRoles, String delFlag, Long createBy, Date createTime, Long updateBy, Date updateTime) {
        this.userId = userId;
        this.userAccount = userAccount;
        this.userPassword = userPassword;
        this.nickName = nickName;
        this.userAvatar = userAvatar;
        this.userProfile = userProfile;
        this.userRoles = userRoles;
        this.delFlag = delFlag;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
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
     * @return userPassword
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * 设置
     * @param userPassword
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
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
     * @return userAvatar
     */
    public String getUserAvatar() {
        return userAvatar;
    }

    /**
     * 设置
     * @param userAvatar
     */
    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
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

    /**
     * 获取
     * @return delFlag
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 设置
     * @param delFlag
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
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
     * @return createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
     * @return updateTime
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String toString() {
        return "User{userId = " + userId + ", userAccount = " + userAccount + ", userPassword = " + userPassword + ", nickName = " + nickName + ", userAvatar = " + userAvatar + ", userProfile = " + userProfile + ", userRoles = " + userRoles + ", delFlag = " + delFlag + ", createBy = " + createBy + ", createTime = " + createTime + ", updateBy = " + updateBy + ", updateTime = " + updateTime + "}";
    }
}