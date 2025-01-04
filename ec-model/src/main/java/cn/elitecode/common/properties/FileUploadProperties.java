package cn.elitecode.common.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "elitecode.fileupload")
public class FileUploadProperties {

    private static String resourcePrefix;

    private static String uploadPath;

    public static String getResourcePrefix() {
        return resourcePrefix;
    }

    public void setResourcePrefix(String resourcePrefix) {
        this.resourcePrefix = resourcePrefix;
    }

    public static String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }

    public static String getAvatarPath() {
        return getUploadPath() + "/avatar";
    }

}
