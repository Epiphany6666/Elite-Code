package cn.elitecode.model.dto.user;

/**
 * 用户注册DTO
 */
public class UserRegisterDTO {

    private String userAccount;
    private String userPassword;
    private String checkPassword;


    public UserRegisterDTO() {
    }

    public UserRegisterDTO(String userAccount, String userPassword, String checkPassword) {
        this.userAccount = userAccount;
        this.userPassword = userPassword;
        this.checkPassword = checkPassword;
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
     * @return checkPassword
     */
    public String getCheckPassword() {
        return checkPassword;
    }

    /**
     * 设置
     * @param checkPassword
     */
    public void setCheckPassword(String checkPassword) {
        this.checkPassword = checkPassword;
    }

    public String toString() {
        return "UserRegisterDTO{userAccount = " + userAccount + ", userPassword = " + userPassword + ", checkPassword = " + checkPassword + "}";
    }
}
