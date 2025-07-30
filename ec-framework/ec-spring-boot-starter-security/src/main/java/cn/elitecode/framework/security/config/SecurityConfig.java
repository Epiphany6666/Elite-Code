package cn.elitecode.framework.security.config;

import cn.elitecode.framework.security.core.RestAuthenticationEntryPoint;
import cn.elitecode.framework.security.core.filter.JwtAuthenticationTokenFilter;
import cn.elitecode.framework.security.core.handler.LogoutSuccessHandlerImpl;
import cn.elitecode.framework.security.core.handler.RestfulAccessDeniedHandler;
import cn.elitecode.framework.security.core.manager.DynamicAuthorizationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authorization.AuthenticatedAuthorizationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
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
    private RestfulAccessDeniedHandler restfulAccessDeniedHandler;
    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;
    @Autowired(required = false)
    private DynamicAuthorizationManager dynamicAuthorizationManager;

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
                // CSRF（跨站请求伪造）禁用，因为不使用session
                .csrf(csrf -> csrf.disable())
                // 基于token获取SecurityContext，所以不需要session
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                // 注解标记允许匿名访问的url
                .authorizeHttpRequests((requests) -> {
                    // 允许匿名访问（即无需认证就可以进行访问）
                    requests.antMatchers(ignoreUrlConfig.getUrls()).permitAll()
                            // 仅需登录就可以访问的url
                            .antMatchers(ignoreUrlConfig.getAppUrls()).authenticated()
                            // 除上面外的所有请求全部需要鉴权认证
                            .anyRequest().access(dynamicAuthorizationManager == null ? AuthenticatedAuthorizationManager.authenticated() : dynamicAuthorizationManager);
                })
                .logout(logout -> logout.logoutUrl("/logout").logoutSuccessHandler(logoutSuccessHandler))
                // 将 JWTFilter 添加到 UsernamePasswordAuthenticationFilter 前面（校验账号密码之前）
                .addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling(configure -> configure.accessDeniedHandler(restfulAccessDeniedHandler).authenticationEntryPoint(restAuthenticationEntryPoint))
                // 添加CORS filter
                .addFilterBefore(corsFilter, JwtAuthenticationTokenFilter.class)
                .addFilterBefore(corsFilter, LogoutFilter.class)
                .build();
    }

}
