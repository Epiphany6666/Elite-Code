package cn.luoyan.elitecode.model.vo;

import lombok.Data;

import java.util.Date;

@Data
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
    private String userRole;

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

}
