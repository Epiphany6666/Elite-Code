package cn.elitecode.framework.core;

import cn.elitecode.web.service.DynamicSecurityService;
import cn.hutool.core.util.URLUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.util.AntPathMatcher;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class DynamicSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    private static Map<String, ConfigAttribute> configAttributeMap = null;
    @Autowired
    private DynamicSecurityService dynamicSecurityService;

    @PostConstruct
    public void loadDataSource() {
        configAttributeMap = dynamicSecurityService.loadDataSource();
    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        // 获取当前访问的路径
        String url = ((FilterInvocation) o).getRequestUrl();
        String path = URLUtil.getPath(url);
        return getConfigAttributesWithPath(path);
    }

    // 根据当前访问的路径获取对应的权限
    public List<ConfigAttribute> getConfigAttributesWithPath(String path) {
        if (configAttributeMap == null) this.loadDataSource();
        List<ConfigAttribute> configAttributeList = new ArrayList<>();
        AntPathMatcher pathMatcher = new AntPathMatcher();
        // 获取访问该路径所需资源
        for (String pattern : configAttributeMap.keySet()) {
            if (pathMatcher.match(pattern, path)) {
                configAttributeList.add(configAttributeMap.get(pattern));
            }
        }
        // 未设置操作请求权限，则返回空集合
        return configAttributeList;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
