package cn.elitecode.web.service.impl;

import cn.elitecode.model.entity.Resource;
import cn.elitecode.service.ResourceService;
import cn.elitecode.web.service.DynamicSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DynamicSecurityServiceImpl implements DynamicSecurityService {

    @Autowired
    private ResourceService resourceService;

    @Override
    public Map<String, ConfigAttribute> loadDataSource() {
        Map<String, ConfigAttribute> map = new HashMap<>();
        List<Resource> resourceList = resourceService.listResourceAll();
        for (Resource resource : resourceList) {
            map.put(resource.getUrl(), new org.springframework.security.access.SecurityConfig(resource.getId() + ":" + resource.getName()));
        }
        return map;
    }
}
