package cn.elitecode.web.config;

import cn.elitecode.common.exception.user.UsernameNotFoundException;
import cn.elitecode.common.utils.JwtTokenUtil;
import cn.elitecode.constant.HttpStatus;
import cn.elitecode.mapper.ResourceMapper;
import cn.elitecode.mapper.UserMapper;
import cn.elitecode.model.bo.LoginUser;
import cn.elitecode.model.entity.Resource;
import cn.elitecode.model.entity.User;
import cn.elitecode.web.handler.DynamicAuthorizationManager;
import cn.elitecode.web.handler.DynamicSecurityMetadataSource;
import cn.elitecode.web.service.DynamicSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class ECSecurityConfig {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ResourceMapper resourceMapper;

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            /**
             * 获取用户信息
             * @param username
             * @return
             */
            @Override
            public UserDetails loadUserByUsername(String username) {
                // 查询用户是否存在
                User user = userMapper.selectUserByUsername(username);
                if (user == null) {
                    throw new UsernameNotFoundException(HttpStatus.PARAMS_ERROR, "账号或密码错误");
                }
                List<Resource> resourceList = resourceMapper.selectResourceByUserId(user.getId());
                return new LoginUser(user, resourceList);
            }
        };
    }


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

    @Bean
    public JwtTokenUtil jwtTokenUtil() {
        return new JwtTokenUtil();
    }

}
