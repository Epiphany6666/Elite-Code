package cn.elitecode.model.entity;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 * user(用户表) | 实体类
 * @TableName
 */
public class User {

    @ApiModelProperty(value = "用户ID")
    private Long id;

    @ApiModelProperty(value = "账号（唯一）")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "用户昵称")
    private String nickName;

    @ApiModelProperty(value = "用户头像")
    private String avatar;

    @ApiModelProperty(value = "用户简介")
    private String profile;

    @ApiModelProperty(value = "删除标志（0代表存在，2代表删除）")
    private String delFlag;

    @ApiModelProperty(value = "创建者")
    private Long createBy;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新者")
    private Long updateBy;

    @ApiModelProperty(value = "编辑时间")
    private Date updateTime;

    public User(Long userId) {
        this.id = userId;
    }

    public User() {
    }

    public User(Long id, String username, String password, String nickName, String avatar, String profile, String delFlag, Long createBy, Date createTime, Long updateBy, Date updateTime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nickName = nickName;
        this.avatar = avatar;
        this.profile = profile;
        this.delFlag = delFlag;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
    }

    /**
     * 用户ID
     */
    public void setId(Long id){
        this.id = id;
    }

    /**
     * 账号
     */
    public void setUsername(String username){
        this.username = username;
    }

    /**
     * 密码
     */
    public void setPassword(String password){
        this.password = password;
    }

    /**
     * 用户昵称
     */
    public void setNickName(String nickName){
        this.nickName = nickName;
    }

    /**
     * 用户头像
     */
    public void setAvatar(String avatar){
        this.avatar = avatar;
    }

    /**
     * 用户简介
     */
    public void setProfile(String profile){
        this.profile = profile;
    }

    /**
     * 删除标志（0代表存在，2代表删除）
     */
    public void setDelFlag(String delFlag){
        this.delFlag = delFlag;
    }

    /**
     * 创建者
     */
    public void setCreateBy(Long createBy){
        this.createBy = createBy;
    }

    /**
     * 创建时间
     */
    public void setCreateTime(Date createTime){
        this.createTime = createTime;
    }

    /**
     * 更新者
     */
    public void setUpdateBy(Long updateBy){
        this.updateBy = updateBy;
    }

    /**
     * 编辑时间
     */
    public void setUpdateTime(Date updateTime){
        this.updateTime = updateTime;
    }


    /**
     * 用户ID
     */
    public Long getId(){
        return this.id;
    }

    /**
     * 账号
     */
    public String getUsername(){
        return this.username;
    }

    /**
     * 密码
     */
    public String getPassword(){
        return this.password;
    }

    /**
     * 用户昵称
     */
    public String getNickName(){
        return this.nickName;
    }

    /**
     * 用户头像
     */
    public String getAvatar(){
        return this.avatar;
    }

    /**
     * 用户简介
     */
    public String getProfile(){
        return this.profile;
    }

    /**
     * 删除标志（0代表存在，2代表删除）
     */
    public String getDelFlag(){
        return this.delFlag;
    }

    /**
     * 创建者
     */
    public Long getCreateBy(){
        return this.createBy;
    }

    /**
     * 创建时间
     */
    public Date getCreateTime(){
        return this.createTime;
    }

    /**
     * 更新者
     */
    public Long getUpdateBy(){
        return this.updateBy;
    }

    /**
     * 编辑时间
     */

    public String toString() {
        return "User{id = " + id + ", username = " + username + ", password = " + password + ", nickName = " + nickName + ", avatar = " + avatar + ", profile = " + profile + ", delFlag = " + delFlag + ", createBy = " + createBy + ", createTime = " + createTime + ", updateBy = " + updateBy + ", updateTime = " + updateTime + "}";
    }

}