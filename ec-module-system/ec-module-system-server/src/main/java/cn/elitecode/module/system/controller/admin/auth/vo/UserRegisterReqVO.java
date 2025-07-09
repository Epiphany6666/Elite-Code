package cn.elitecode.module.system.controller.admin.auth.vo;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * 用户注册DTO
 */
public class UserRegisterReqVO {

    @ApiModelProperty(value = "用户账号", required = true)
    @NotEmpty(message = "用户账号不能为空")
    @Size(min = 2, max = 20, message = "账号长度必须在2到20个字符之间")
    private String username;

    @ApiModelProperty(value = "用户密码", required = true)
    @NotEmpty(message = "用户密码不能为空")
    @Size(min = 6, max = 20, message = "密码长度必须在6到20个字符之间")
    private String password;

    @ApiModelProperty(value = "校验密码", required = true)
    @NotEmpty(message = "校验密码不能为空")
    private String checkPassword;

    public UserRegisterReqVO() {
    }

    public UserRegisterReqVO(String username, String password, String checkPassword) {
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
        return "UserRegisterReqVO{username = " + username + ", password = " + password + ", checkPassword = " + checkPassword + "}";
    }

}
