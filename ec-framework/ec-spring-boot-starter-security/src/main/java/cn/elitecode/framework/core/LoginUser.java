package cn.elitecode.framework.core;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * 已登录用户
 */
public class LoginUser {

    @ApiModelProperty(value = "用户id")
    private Long id;
    @ApiModelProperty(value = "用户唯一标识")
    private String token;
    @ApiModelProperty(value = "用户类型")
    private Integer userType;
    @ApiModelProperty(value = "权限集合")
    Collection<? extends GrantedAuthority> authorities;
    @ApiModelProperty(value = "过期时间")
    private Long expireTime;

    public LoginUser(Integer userType, Collection<? extends GrantedAuthority> authorities) {
        this.userType = userType;
        this.authorities = authorities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUserType() {
        return userType;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
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

    /**
     * 获取
     * @return loginTime
     */
    public Long getExpireTime() {
        return expireTime;
    }

    /**
     * 设置
     * @param expireTime
     */
    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }

    public String toString() {
        return "LoginUser{token = " + token + ", loginTime = " + expireTime + "}";
    }
}
