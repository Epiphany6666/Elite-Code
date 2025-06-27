package cn.elitecode.module.member.controller.app.auth.vo;

import io.swagger.annotations.ApiModelProperty;

public class AppAuthLoginRespVO {

    @ApiModelProperty(value = "token头")
    private String tokenHead;
    @ApiModelProperty(value = "用户唯一标识")
    private String token;

    public AppAuthLoginRespVO() {
    }

    public AppAuthLoginRespVO(String tokenHead, String token) {
        this.tokenHead = tokenHead;
        this.token = token;
    }

    /**
     * 获取
     * @return tokenHead
     */
    public String getTokenHead() {
        return tokenHead;
    }

    /**
     * 设置
     * @param tokenHead
     */
    public void setTokenHead(String tokenHead) {
        this.tokenHead = tokenHead;
    }

    /**
     * 获取
     * @return token
     */
    public String getToken() {
        return token;
    }

    /**
     * 设置
     * @param token
     */
    public void setToken(String token) {
        this.token = token;
    }

    public String toString() {
        return "AppAuthLoginRespVO{tokenHead = " + tokenHead + ", token = " + token + "}";
    }
}
