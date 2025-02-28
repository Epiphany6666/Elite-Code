package cn.elitecode.model.dto.user;

/**
 * 用户注册DTO
 */
public class UserRegisterDTO {

    private String account;
    private String password;
    private String checkPassword;


    public UserRegisterDTO() {
    }

    public UserRegisterDTO(String account, String password, String checkPassword) {
        this.account = account;
        this.password = password;
        this.checkPassword = checkPassword;
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
     * @return userPassword
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
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
        return "UserRegisterDTO{userAccount = " + account + ", userPassword = " + password + ", checkPassword = " + checkPassword + "}";
    }
}
