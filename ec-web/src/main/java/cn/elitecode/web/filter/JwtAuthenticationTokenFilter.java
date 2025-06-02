package cn.elitecode.web.filter;

import cn.elitecode.common.properties.JWTProperties;
import cn.elitecode.common.utils.JwtTokenUtil;
import cn.elitecode.model.bo.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader(JWTProperties.getTokenHeader());
        if (authHeader != null && authHeader.startsWith(JWTProperties.getTokenHead())) {
            String authToken = authHeader.substring(JWTProperties.getTokenHead().length());
            LoginUser loginUser = jwtTokenUtil.getLoginUser(authToken);
            if (loginUser != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                // 将用户信息存入SecurityContext
                jwtTokenUtil.verifyToken(loginUser);
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUser, null, loginUser.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }
        filterChain.doFilter(request, response);
    }
}
