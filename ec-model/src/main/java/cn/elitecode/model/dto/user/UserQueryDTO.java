package cn.elitecode.model.dto.user;

import cn.elitecode.common.PageRequest;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户查询DTO
 */
public class UserQueryDTO extends PageRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = -4231433818967834013L;
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
     * 用户角色：user/admin/ban
     */
    private String role;

    /**
     * 创建者
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date startTime;

    /**
     * 更新者
     */
    private String updateBy;

    /**
     * 编辑时间
     */
    private Date endTime;


    public UserQueryDTO() {
    }

    public UserQueryDTO(Long userId, String userAccount, String nickName, String role, String createBy, Date startTime, String updateBy, Date endTime) {
        this.id = userId;
        this.account = userAccount;
        this.nickName = nickName;
        this.role = role;
        this.createBy = createBy;
        this.startTime = startTime;
        this.updateBy = updateBy;
        this.endTime = endTime;
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
     * @return userRole
     */
    public String getRole() {
        return role;
    }

    /**
     * 设置
     * @param role
     */
    public void setRole(String role) {
        this.role = role;
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
        return "UserQueryDTO{userId = " + id + ", userAccount = " + account + ", nickName = " + nickName + ", userRole = " + role + ", createBy = " + createBy + ", startTime = " + startTime + ", updateBy = " + updateBy + ", endTime = " + endTime + "}";
    }
}
