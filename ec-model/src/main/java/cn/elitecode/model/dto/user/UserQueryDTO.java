package cn.elitecode.model.dto.user;

import cn.elitecode.common.PageRequest;

import java.util.Date;

/**
 * 用户查询DTO
 */
public class UserQueryDTO extends PageRequest {

    /**
     * 用户ID
     */
    private Long id;

    /**
     * 账号
     */
    private String username;

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
     * 更新者
     */
    private String updateBy;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    public UserQueryDTO() {
    }

    public UserQueryDTO(Long id, String username, String nickName, String role, String createBy, String updateBy, Date startTime, Date endTime) {
        this.id = id;
        this.username = username;
        this.nickName = nickName;
        this.role = role;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.startTime = startTime;
        this.endTime = endTime;
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
     * @return role
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
        return "UserQueryDTO{id = " + id + ", username = " + username + ", nickName = " + nickName + ", role = " + role + ", createBy = " + createBy + ", updateBy = " + updateBy + ", startTime = " + startTime + ", endTime = " + endTime + "}";
    }
}
