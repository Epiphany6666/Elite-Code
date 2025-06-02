package cn.elitecode.common.service;

import java.util.concurrent.TimeUnit;

public interface RedisService {
    /**
     * 设置属性
     * @param key
     * @param value
     * @param expiration
     * @param timeUnit
     */
    void set(String key, Object value, long expiration, TimeUnit timeUnit);

    /**
     * 获取属性
     * @param key
     * @return
     */
    <T> T get(String key);

    /**
     * 删除属性
     * @param token
     */
    void del(String token);
}
