package cn.elitecode.module.member.controller.app.auth.vo;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;

public class AppAuthLoginReqVO {

    @ApiModelProperty(value = "手机号", required = true)
    @NotEmpty(message = "手机号不能为空")
    private String mobile;
    @ApiModelProperty(value = "密码", required = true)
    @NotEmpty(message = "密码不能为空")
    private String password;

    public AppAuthLoginReqVO() {
    }

    public AppAuthLoginReqVO(String mobile, String password) {
        this.mobile = mobile;
        this.password = password;
    }

    /**
     * 获取
     * @return mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置
     * @param mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
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

    public String toString() {
        return "AppAuthLoginReqVO{mobile = " + mobile + ", password = " + password + "}";
    }
}
