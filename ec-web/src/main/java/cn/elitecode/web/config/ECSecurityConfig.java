package cn.elitecode.web.config;

import cn.elitecode.framework.core.DynamicSecurityMetadataSource;
import cn.elitecode.framework.core.manager.DynamicAuthorizationManager;
import cn.elitecode.mapper.ResourceMapper;
import cn.elitecode.model.entity.Resource;
import cn.elitecode.web.service.DynamicSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.ConfigAttribute;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class ECSecurityConfig {

    @Autowired
    private ResourceMapper resourceMapper;

    @Bean
    public DynamicSecurityService dynamicSecurityService() {
        return new DynamicSecurityService() {
            @Override
            public Map<String, ConfigAttribute> loadDataSource() {
                Map<String, ConfigAttribute> map = new HashMap<>();
                List<Resource> resourceList = resourceMapper.selectResourceAll();
                for (Resource resource : resourceList) {
                    map.put(resource.getUrl(), new org.springframework.security.access.SecurityConfig(resource.getId() + ":" + resource.getName()));
                }
                return map;
            }
        };
    }

    @ConditionalOnBean(name = "dynamicSecurityService")
    @Bean
    public DynamicAuthorizationManager dynamicAuthorizationManager() {
        return new DynamicAuthorizationManager();
    }

    @ConditionalOnBean(name = "dynamicSecurityService")
    @Bean
    public DynamicSecurityMetadataSource dynamicSecurityMetadataSource() {
        return new DynamicSecurityMetadataSource();
    }

}
