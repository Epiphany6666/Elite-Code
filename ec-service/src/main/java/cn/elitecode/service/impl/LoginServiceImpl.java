package cn.elitecode.service.impl;

import cn.elitecode.common.properties.JWTProperties;
import cn.elitecode.constant.JWTConstant;
import cn.elitecode.service.LoginService;
import cn.hutool.core.date.DateUtil;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.signers.JWTSignerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import java.util.HashMap;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public String login(String username, String userPassword) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, userPassword);
        // 该方法会去调用UserDetailsServiceImpl.loadUserByUsername，并将返回的UserDetails设置到SecurityContext中
        authenticationManager.authenticate(authenticationToken);
        // 生成jwt令牌
        HashMap<String, Object> claims = new HashMap<>();
        claims.put(JWTConstant.CLAIM_KEY_USERNAME, username);
        String token = JWT.create()
                .addPayloads(claims)
                .setSigner(JWTSignerUtil.hs256(JWTProperties.getSecret().getBytes()))
                // (签发时间)---------(生效时间)---------(当前时间)---------(失效时间)
                // 签发时间
                .setIssuedAt(DateUtil.date())
                // 失效时间
                .setExpiresAt(DateUtil.offsetSecond(DateUtil.date(), JWTProperties.getExpiration()))
                .sign();
        return token;
    }

}
