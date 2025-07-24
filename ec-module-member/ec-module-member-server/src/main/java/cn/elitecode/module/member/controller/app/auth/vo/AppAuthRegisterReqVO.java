package cn.elitecode.module.member.controller.app.auth.vo;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class AppAuthRegisterReqVO {

    @ApiModelProperty(value = "手机号", required = true)
    @NotEmpty(message = "手机号不能为空")
    private String phone;

    @ApiModelProperty(value = "用户密码", required = true)
    @NotEmpty(message = "用户密码不能为空")
    @Size(min = 6, max = 20, message = "密码长度必须在6到20个字符之间")
    private String password;

    @ApiModelProperty(value = "校验密码", required = true)
    @NotEmpty(message = "校验密码不能为空")
    private String checkPassword;

    public AppAuthRegisterReqVO(String phone, String password, String checkPassword) {
        this.phone = phone;
        this.password = password;
        this.checkPassword = checkPassword;
    }

    public AppAuthRegisterReqVO() {
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCheckPassword() {
        return checkPassword;
    }

    public void setCheckPassword(String checkPassword) {
        this.checkPassword = checkPassword;
    }
}
