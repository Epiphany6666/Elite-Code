package cn.elitecode.model.dto.user;

/**
 * 用户注册DTO
 */
public class UserRegisterDTO {

    private String username;
    private String password;
    private String checkPassword;

    public UserRegisterDTO() {
    }

    public UserRegisterDTO(String username, String password, String checkPassword) {
        this.username = username;
        this.password = password;
        this.checkPassword = checkPassword;
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
     * @return password
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
        return "UserRegisterDTO{username = " + username + ", password = " + password + ", checkPassword = " + checkPassword + "}";
    }

}
