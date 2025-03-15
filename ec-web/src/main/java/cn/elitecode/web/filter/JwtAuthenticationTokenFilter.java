package cn.elitecode.web.filter;

import cn.elitecode.common.exception.BaseException;
import cn.elitecode.common.properties.JWTProperties;
import cn.elitecode.constant.HttpStatus;
import cn.elitecode.constant.JWTConstant;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.exceptions.ValidateException;
import cn.hutool.jwt.JWTUtil;
import cn.hutool.jwt.JWTValidator;
import cn.hutool.jwt.signers.JWTSignerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
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
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader(JWTProperties.getTokenHeader());
        if (authHeader != null && authHeader.startsWith(JWTProperties.getTokenHead())) {
            String authToken = authHeader.substring(JWTProperties.getTokenHead().length());
            try {
                // 校验签名是否合法
                JWTValidator.of(JWTUtil.parseToken(authToken))
                        .validateAlgorithm(JWTSignerUtil.hs256(JWTProperties.getSecret().getBytes()))
                        .validateDate(DateUtil.date());
            } catch (ValidateException e) {
                throw new BaseException(HttpStatus.PARAMS_ERROR, "Token不合法");
            }
            // 将用户信息存入SecurityContext
            String username = (String) JWTUtil.parseToken(authToken).getPayload(JWTConstant.CLAIM_KEY_USERNAME);
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request, response);
    }
}
