package cn.luoyan.elitecode.model.dto.user;

import cn.luoyan.elitecode.common.PageRequest;
import com.fasterxml.jackson.annotation.JsonFormat;
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
     * 用户角色：user/admin/ban
     */
    private String userRole;

    /**
     * 创建者
     */
    private String createBy;

    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    /**
     * 更新者
     */
    private String updateBy;

    /**
     * 编辑时间
     */
    @JsonFormat(locale="zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;


    public UserQueryDTO() {
    }

    public UserQueryDTO(Long userId, String userAccount, String nickName, String userRole, String createBy, Date startTime, String updateBy, Date endTime) {
        this.userId = userId;
        this.userAccount = userAccount;
        this.nickName = nickName;
        this.userRole = userRole;
        this.createBy = createBy;
        this.startTime = startTime;
        this.updateBy = updateBy;
        this.endTime = endTime;
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
     * @return userRole
     */
    public String getUserRole() {
        return userRole;
    }

    /**
     * 设置
     * @param userRole
     */
    public void setUserRole(String userRole) {
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
        return "UserQueryDTO{userId = " + userId + ", userAccount = " + userAccount + ", nickName = " + nickName + ", userRole = " + userRole + ", createBy = " + createBy + ", startTime = " + startTime + ", updateBy = " + updateBy + ", endTime = " + endTime + "}";
    }
}
