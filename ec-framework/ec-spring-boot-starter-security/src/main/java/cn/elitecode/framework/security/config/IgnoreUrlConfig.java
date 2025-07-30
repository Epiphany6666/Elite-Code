package cn.elitecode.framework.security.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "secure.ignored")
public class IgnoreUrlConfig {

    private String[] urls;

    private String[] appUrls;

    /**
     * 获取
     * @return urls
     */
    public String[] getUrls() {
        return urls;
    }

    /**
     * 设置
     * @param urls
     */
    public void setUrls(String[] urls) {
        this.urls = urls;
    }

    public String[] getAppUrls() {
        return appUrls;
    }

    public void setAppUrls(String[] appUrls) {
        this.appUrls = appUrls;
    }
}
