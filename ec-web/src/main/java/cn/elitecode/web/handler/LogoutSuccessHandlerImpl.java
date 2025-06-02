package cn.elitecode.web.handler;

import cn.elitecode.common.api.CommonResult;
import cn.elitecode.common.properties.JWTProperties;
import cn.elitecode.common.utils.JwtTokenUtil;
import cn.elitecode.model.bo.LoginUser;
import cn.hutool.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class LogoutSuccessHandlerImpl implements LogoutSuccessHandler {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String token = request.getHeader(JWTProperties.getTokenHeader());
        if (token != null && token.startsWith(JWTProperties.getTokenHead())) {
            String authToken = token.substring(JWTProperties.getTokenHead().length());
            LoginUser loginUser = jwtTokenUtil.getLoginUser(authToken);
            if (loginUser != null) {
                jwtTokenUtil.delLoginUser(loginUser.getToken());
            }
            response.setStatus(200);
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(JSONUtil.toJsonStr(CommonResult.success()));
        }
    }
}
