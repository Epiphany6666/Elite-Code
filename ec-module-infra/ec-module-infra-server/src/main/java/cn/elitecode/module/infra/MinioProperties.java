package cn.elitecode.module.infra;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "minio")
public class MinioProperties {

    private static String url;
    private static String endpoint;
    private static String bucketName;
    private static String accessKey;
    private static String secretKey;

    /**
     * 获取
     * @return endpoint
     */
    public static String getEndpoint() {
        return endpoint;
    }

    /**
     * 获取
     * @return url
     */
    public static String getUrl() {
        return url;
    }

    /**
     * 设置
     * @param url
     */
    public void setUrl(String url) {
        MinioProperties.url = url;
    }

    /**
     * 设置
     * @param endpoint
     */
    public void setEndpoint(String endpoint) {
        MinioProperties.endpoint = endpoint;
    }

    /**
     * 获取
     * @return bucketName
     */
    public static String getBucketName() {
        return bucketName;
    }

    /**
     * 设置
     * @param bucketName
     */
    public void setBucketName(String bucketName) {
        MinioProperties.bucketName = bucketName;
    }

    /**
     * 获取
     * @return accessKey
     */
    public static String getAccessKey() {
        return accessKey;
    }

    /**
     * 设置
     * @param accessKey
     */
    public void setAccessKey(String accessKey) {
        MinioProperties.accessKey = accessKey;
    }

    /**
     * 获取
     * @return secretKey
     */
    public static String getSecretKey() {
        return secretKey;
    }

    /**
     * 设置
     * @param secretKey
     */
    public void setSecretKey(String secretKey) {
        MinioProperties.secretKey = secretKey;
    }
}
