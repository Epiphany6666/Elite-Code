package cn.luoyan.elitecode.model.dto.user;

public class UserLoginDTO {

    private String userAccount;
    private String userPassword;


    public UserLoginDTO() {
    }

    public UserLoginDTO(String userAccount, String userPassword) {
        this.userAccount = userAccount;
        this.userPassword = userPassword;
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

    public String toString() {
        return "UserLoginDTO{userAccount = " + userAccount + ", userPassword = " + userPassword + "}";
    }
}
