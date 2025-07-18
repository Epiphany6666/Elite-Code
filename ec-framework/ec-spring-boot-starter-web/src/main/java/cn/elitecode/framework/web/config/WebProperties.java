package cn.elitecode.framework.web.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class WebProperties {

    public Api appApi = new Api("/app-api", "**.controller.app.**");
    public Api adminApi = new Api("/admin-api", "**.controller.admin.**");

    public WebProperties() {
    }

    public WebProperties(Api appApi, Api adminApi) {
        this.appApi = appApi;
        this.adminApi = adminApi;
    }

    /**
     * 获取
     * @return appApi
     */
    public Api getAppApi() {
        return appApi;
    }

    /**
     * 设置
     * @param appApi
     */
    public void setAppApi(Api appApi) {
        this.appApi = appApi;
    }

    /**
     * 获取
     * @return adminApi
     */
    public Api getAdminApi() {
        return adminApi;
    }

    /**
     * 设置
     * @param adminApi
     */
    public void setAdminApi(Api adminApi) {
        this.adminApi = adminApi;
    }

    public static class Api {
        private String prefix;
        private String controller;

        public Api(String prefix, String controller) {
            this.prefix = prefix;
            this.controller = controller;
        }

        public Api() {
        }

        /**
         * 获取
         * @return prefix
         */
        public String getPrefix() {
            return prefix;
        }

        /**
         * 设置
         * @param prefix
         */
        public void setPrefix(String prefix) {
            this.prefix = prefix;
        }

        /**
         * 获取
         * @return controller
         */
        public String getController() {
            return controller;
        }

        /**
         * 设置
         * @param controller
         */
        public void setController(String controller) {
            this.controller = controller;
        }
    }
}
