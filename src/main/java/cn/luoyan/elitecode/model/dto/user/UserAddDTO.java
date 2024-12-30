package cn.luoyan.elitecode.model.dto.user;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public class UserAddDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -2664868203037041401L;

    /**
     * 账号
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

    public UserAddDTO() {
    }

    public UserAddDTO(String userAccount, String userPassword, String nickName, String userAvatar, String userProfile, List<String> userRoles) {
        this.userAccount = userAccount;
        this.userPassword = userPassword;
        this.nickName = nickName;
        this.userAvatar = userAvatar;
        this.userProfile = userProfile;
        this.userRoles = userRoles;
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

    public String toString() {
        return "UserAddDTO{userAccount = " + userAccount + ", userPassword = " + userPassword + ", nickName = " + nickName + ", userAvatar = " + userAvatar + ", userProfile = " + userProfile + ", userRoles = " + userRoles + "}";
    }
}
