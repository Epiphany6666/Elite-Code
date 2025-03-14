package cn.elitecode.common.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "jwt")
public class JWTProperties {

    private static String tokenHeader;

    private static String secret;

    private static int expiration;

    private static String tokenHead;

    /**
     * 获取
     * @return tokenHeader
     */
    public static String getTokenHeader() {
        return tokenHeader;
    }

    /**
     * 设置
     * @param tokenHeader
     */
    public void setTokenHeader(String tokenHeader) {
        JWTProperties.tokenHeader = tokenHeader;
    }

    /**
     * 获取
     * @return secret
     */
    public static String getSecret() {
        return secret;
    }

    /**
     * 设置
     * @param secret
     */
    public void setSecret(String secret) {
        JWTProperties.secret = secret;
    }

    /**
     * 获取
     * @return expiration
     */
    public static int getExpiration() {
        return expiration;
    }

    /**
     * 设置
     * @param expiration
     */
    public void setExpiration(int expiration) {
        JWTProperties.expiration = expiration;
    }

    /**
     * 获取
     * @return tokenHead
     */
    public static String getTokenHead() {
        return tokenHead;
    }

    /**
     * 设置
     * @param tokenHead
     */
    public void setTokenHead(String tokenHead) {
        JWTProperties.tokenHead = tokenHead;
    }

}
