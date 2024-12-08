package cn.luoyan.elitecode.model.vo;

import java.util.Date;
import java.util.List;

public class UserVO {

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
    private List<String> userRole;

    /**
     * 创建者
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新者
     */
    private String updateBy;

    /**
     * 编辑时间
     */
    private Date updateTime;

    public UserVO() {
    }

    public UserVO(Long userId, String userAccount, String nickName, String userAvatar, String userProfile, List<String> userRole, String createBy, Date createTime, String updateBy, Date updateTime) {
        this.userId = userId;
        this.userAccount = userAccount;
        this.nickName = nickName;
        this.userAvatar = userAvatar;
        this.userProfile = userProfile;
        this.userRole = userRole;
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
     * @return userRole
     */
    public List<String> getUserRole() {
        return userRole;
    }

    /**
     * 设置
     * @param userRole
     */
    public void setUserRole(List<String> userRole) {
        this.userRole = userRole;
    }

    /**
     * 获取
     * @return createBy
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置
     * @param createBy
     */
    public void setCreateBy(String createBy) {
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
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置
     * @param updateBy
     */
    public void setUpdateBy(String updateBy) {
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
        return "UserVO{userId = " + userId + ", userAccount = " + userAccount + ", nickName = " + nickName + ", userAvatar = " + userAvatar + ", userProfile = " + userProfile + ", userRole = " + userRole + ", createBy = " + createBy + ", createTime = " + createTime + ", updateBy = " + updateBy + ", updateTime = " + updateTime + "}";
    }
}
