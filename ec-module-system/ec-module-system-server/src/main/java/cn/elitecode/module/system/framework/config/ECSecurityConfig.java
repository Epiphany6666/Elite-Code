package cn.elitecode.module.system.framework.config;

import cn.elitecode.framework.security.core.service.DynamicSecurityService;
import cn.elitecode.module.system.dal.dataobject.permission.ResourceDO;
import cn.elitecode.module.system.dal.mysql.permmison.ResourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
                List<ResourceDO> resourceDOList = resourceMapper.selectResourceAll();
                for (ResourceDO resourceDO : resourceDOList) {
                    map.put(resourceDO.getUrl(), new org.springframework.security.access.SecurityConfig(resourceDO.getId() + ":" + resourceDO.getName()));
                }
                return map;
            }
        };
    }

}
