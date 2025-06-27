package cn.elitecode.framework.core.utils;

import cn.elitecode.common.properties.JWTProperties;
import cn.elitecode.common.service.RedisService;
import cn.elitecode.constant.CacheConstant;
import cn.elitecode.constant.JWTConstant;
import cn.elitecode.framework.core.LoginUser;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import cn.hutool.jwt.signers.JWTSignerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

@Component
public class JwtTokenUtil {

    private Logger logger = LoggerFactory.getLogger(JwtTokenUtil.class);

    @Autowired
    private RedisService redisService;

    /**
     * 创建令牌
     * @param loginUser
     * @return
     */
    public String createToken(LoginUser loginUser) {
        String token = IdUtil.fastSimpleUUID();
        loginUser.setToken(token);
        refreshToken(loginUser);

        // 生成jwt令牌
        HashMap<String, Object> claims = new HashMap<>();
        claims.put(JWTConstant.LOGIN_USER_KEY, token);
        String jwtToken = JWT.create()
                .addPayloads(claims)
                .setSigner(JWTSignerUtil.hs256(JWTProperties.getSecret().getBytes()))
                .sign();
        return jwtToken;
    }

    /**
     * 获取用户身份信息
     * @param authToken
     * @return
     */
    public LoginUser getLoginUser(String authToken) {
        if (StrUtil.isNotEmpty(authToken)) {
            try {
                String uuid = (String) JWTUtil.parseToken(authToken).getPayload(JWTConstant.LOGIN_USER_KEY);
                String tokenKey = getTokenKey(uuid);
                LoginUser loginUser = redisService.get(tokenKey);
                return loginUser;
            } catch (Exception e) {
                logger.error("获取用户信息异常：{}", e.getMessage());
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 删除用户身份信息
     * @param token
     */
    public void delLoginUser(String token) {
        if (StrUtil.isNotEmpty(token)) {
            String tokenKey = getTokenKey(token);
            redisService.del(tokenKey);
        }
    }
    /**
     * 验证令牌是否有效，低于20min，自动刷新
     * @param loginUser
     */
    public void verifyToken(LoginUser loginUser) {
        Long expireTime = loginUser.getExpireTime();
        long current = System.currentTimeMillis();
        if (expireTime - current <= JWTProperties.getAutoRefreshTime()) {
            refreshToken(loginUser);
        }
    }

    /**
     * 刷新Token
     * @param loginUser
     */
    private void refreshToken(LoginUser loginUser) {
        loginUser.setExpireTime(System.currentTimeMillis() + JWTProperties.getExpiration());
        String tokenKey = getTokenKey(loginUser.getToken());
        redisService.set(tokenKey, loginUser, JWTProperties.getExpiration(), TimeUnit.MILLISECONDS);
    }

    /**
     * 获取redis中存储用户信息的key
     * @param uuid
     * @return
     */
    private static String getTokenKey(String uuid) {
        return CacheConstant.LOGIN_TOKEN_KEY + uuid;
    }
}
