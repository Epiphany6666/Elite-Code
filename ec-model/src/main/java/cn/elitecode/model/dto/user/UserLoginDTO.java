package cn.elitecode.model.dto.user;

/**
 * 用户登录DTO
 */
public class UserLoginDTO {

    private String account;
    private String password;


    public UserLoginDTO() {
    }

    public UserLoginDTO(String userAccount, String userPassword) {
        this.account = userAccount;
        this.password = userPassword;
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

    public String toString() {
        return "UserLoginDTO{userAccount = " + account + ", userPassword = " + password + "}";
    }
}
