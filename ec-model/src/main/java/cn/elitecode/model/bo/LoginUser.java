package cn.elitecode.model.bo;

import cn.elitecode.model.entity.Resource;
import cn.elitecode.model.entity.User;
import com.alibaba.fastjson2.annotation.JSONField;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 已登录用户
 */
public class LoginUser implements UserDetails {

    @ApiModelProperty(value = "用户唯一标识")
    private String token;
    @ApiModelProperty(value = "用户信息")
    private User user;
    @ApiModelProperty(value = "拥有的资源列表")
    private List<Resource> resourceList;
    @ApiModelProperty(value = "过期时间")
    private Long expireTime;

    public LoginUser(User user, List<Resource> resourceList) {
        this.user = user;
        this.resourceList = resourceList;
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
     * @return user
     */
    public User getUser() {
        return user;
    }

    /**
     * 设置
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * 获取
     * @return resourceList
     */
    public List<Resource> getResourceList() {
        return resourceList;
    }

    /**
     * 设置
     * @param resourceList
     */
    public void setResourceList(List<Resource> resourceList) {
        this.resourceList = resourceList;
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
        return "LoginUser{token = " + token + ", user = " + user + ", resourceList = " + resourceList + ", loginTime = " + expireTime + "}";
    }

    @Override
    @JSONField(serialize = false, deserialize = false)
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return resourceList.stream()
                .map(resource -> new SimpleGrantedAuthority(resource.getId() + ":" + resource.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    /**
     * 指示是否已过期的用户的凭据(密码),过期的凭据防止认证
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 指定用户是否解锁,锁定的用户无法进行身份验证
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 账户是否未过期,过期无法验证
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 是否可用 ,禁用的用户不能身份验证
     * @return
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
