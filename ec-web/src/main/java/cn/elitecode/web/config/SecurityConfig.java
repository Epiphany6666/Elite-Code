package cn.elitecode.web.config;

import cn.elitecode.common.properties.IgnoreUrlConfig;
import cn.elitecode.service.ResourceService;
import cn.elitecode.web.filter.JwtAuthenticationTokenFilter;
import cn.elitecode.web.handler.DynamicAuthorizationManager;
import cn.elitecode.web.handler.LogoutSuccessHandlerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authorization.AuthenticatedAuthorizationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class SecurityConfig {

    /**
     * 跨域过滤器
     */
    @Autowired
    private CorsFilter corsFilter;
    @Autowired
    private UserDetailsService userDetailsService;
    /**
     * 退出处理类
     */
    @Autowired
    private LogoutSuccessHandlerImpl logoutSuccessHandler;
    @Autowired
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;
    @Autowired
    private IgnoreUrlConfig ignoreUrlConfig;
    @Autowired
    private ResourceService resourceService;
    @Autowired
    private DynamicAuthorizationManager dynamicAuthorizationManager;

    /**
     * 身份验证实现
     *
     * @return
     */
    @Bean
    public AuthenticationManager authenticationManager() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder()); // 强散列哈希加密实现
        return new ProviderManager(daoAuthenticationProvider);
    }

    /**
     * SpringSecurity配置
     *
     * @param httpSecurity
     * @return
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                // CSRF禁用，因为不使用session
                .csrf(csrf -> csrf.disable())
                // 基于token获取SecurityContext，所以不需要session
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                // 注解标记允许匿名访问的url
                .authorizeHttpRequests((requests) -> {
                    //  允许匿名访问
                    requests.antMatchers(ignoreUrlConfig.getUrls()).permitAll();
                })
                // 除上面外的所有请求全部需要鉴权认证
                .authorizeHttpRequests(registry ->
                        registry.anyRequest()
                                .access(dynamicAuthorizationManager == null ? AuthenticatedAuthorizationManager.authenticated() : dynamicAuthorizationManager)
                )
                .logout(logout -> logout.logoutUrl("/logout").logoutSuccessHandler(logoutSuccessHandler))
                // 将 JWTFilter 添加到 UsernamePasswordAuthenticationFilter 前面（校验账号密码之前）
                .addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class)
                // 添加CORS filter
                .addFilterBefore(corsFilter, JwtAuthenticationTokenFilter.class)
                .addFilterBefore(corsFilter, LogoutFilter.class)
                .build();
    }

}
