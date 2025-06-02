package cn.elitecode.common.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "jwt")
public class JWTProperties {

    private static String tokenHeader;

    private static String secret;

    private static long expiration;

    private static String tokenHead;

    private static long autoRefreshTime;

    public static String getTokenHeader() {
        return tokenHeader;
    }

    public void setTokenHeader(String tokenHeader) {
        JWTProperties.tokenHeader = tokenHeader;
    }

    public static String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        JWTProperties.secret = secret;
    }

    public static long getExpiration() {
        return expiration;
    }

    public void setExpiration(long expiration) {
        JWTProperties.expiration = expiration;
    }

    public static String getTokenHead() {
        return tokenHead;
    }

    public void setTokenHead(String tokenHead) {
        JWTProperties.tokenHead = tokenHead;
    }

    public static long getAutoRefreshTime() {
        return autoRefreshTime;
    }

    public void setAutoRefreshTime(long refreshTime) {
        JWTProperties.autoRefreshTime = refreshTime;
    }
}
