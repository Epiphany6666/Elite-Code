package cn.elitecode.module.infra.controller.admin.file.vo;

import io.swagger.annotations.ApiModelProperty;

public class MinioUploadReqVO {

    @ApiModelProperty(value = "文件访问URL")
    private String url;
    @ApiModelProperty(value = "文件名称")
    private String filename;

    public MinioUploadReqVO() {
    }

    public MinioUploadReqVO(String url, String filename) {
        this.url = url;
        this.filename = filename;
    }

    /**
     * 获取
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取
     * @return filename
     */
    public String getFilename() {
        return filename;
    }

    /**
     * 设置
     * @param filename
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String toString() {
        return "MinioUploadReqVO{url = " + url + ", filename = " + filename + "}";
    }
}
