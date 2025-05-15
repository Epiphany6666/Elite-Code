package cn.elitecode.web.handler;

import cn.elitecode.common.properties.IgnoreUrlConfig;
import cn.hutool.core.collection.CollUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;
import org.springframework.util.AntPathMatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;

public class DynamicAuthorizationManager implements AuthorizationManager<RequestAuthorizationContext> {

    @Autowired
    private IgnoreUrlConfig ignoreUrlConfig;
    @Autowired
    private DynamicSecurityMetadataSource securityMetadataSource;

    @Override
    public void verify(Supplier<Authentication> authentication, RequestAuthorizationContext object) {
        AuthorizationManager.super.verify(authentication, object);
    }

    @Override
    public AuthorizationDecision check(Supplier<Authentication> authentication, RequestAuthorizationContext requestAuthorizationContext) {
        HttpServletRequest request = requestAuthorizationContext.getRequest();
        String path = request.getRequestURI();
        AntPathMatcher pathMatcher = new AntPathMatcher();
        // 白名单路径直接放行
        String[] urls = ignoreUrlConfig.getUrls();
        for (String url : urls) {
            if (pathMatcher.match(url, path)) {
                return new AuthorizationDecision(true);
            }
        }
        //权限校验逻辑
        List<ConfigAttribute> configAttributeList = securityMetadataSource.getConfigAttributesWithPath(path);
        List<String> needAuthorities = configAttributeList.stream().map(ConfigAttribute::getAttribute).toList();
        Authentication currentAuth = authentication.get();
        // 判定是否已经实现登录认证
        if (currentAuth.isAuthenticated()) {
            Collection<? extends GrantedAuthority> grantedAuthorities = currentAuth.getAuthorities();
            List<? extends GrantedAuthority> hasAuth = grantedAuthorities.stream().filter(item -> needAuthorities.contains(item.getAuthority())).toList();
            if (CollUtil.isNotEmpty(hasAuth)) {
                return new AuthorizationDecision(true);
            } else {
                return new AuthorizationDecision(false);
            }
        } else {
            return new AuthorizationDecision(false);
        }
    }
}
