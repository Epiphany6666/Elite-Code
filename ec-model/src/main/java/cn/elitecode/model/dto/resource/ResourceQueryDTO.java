package cn.elitecode.model.dto.resource;

import cn.elitecode.common.PageRequest;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

public class ResourceQueryDTO extends PageRequest {

    @ApiModelProperty(value="资源名称")
    private String name;

    @ApiModelProperty(value="资源URL")
    private String url;

    @ApiModelProperty(value="分类ID")
    private Long categoryId;

    @ApiModelProperty(value="创建者")
    private Long createBy;

    @ApiModelProperty(value="更新者")
    private Long updateBy;

    @ApiModelProperty(value="开始时间")
    private Date startTime;

    @ApiModelProperty(value="结束时间")
    private Date endTime;

    public ResourceQueryDTO() {
    }

    public ResourceQueryDTO(String name, String url, Long categoryId, Long createBy, Long updateBy, Date startTime, Date endTime) {
        this.name = name;
        this.url = url;
        this.categoryId = categoryId;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
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
     * @return categoryId
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * 设置
     * @param categoryId
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 获取
     * @return createBy
     */
    public Long getCreateBy() {
        return createBy;
    }

    /**
     * 设置
     * @param createBy
     */
    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    /**
     * 获取
     * @return updateBy
     */
    public Long getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置
     * @param updateBy
     */
    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 获取
     * @return startTime
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 设置
     * @param startTime
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取
     * @return endTime
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 设置
     * @param endTime
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String toString() {
        return "ResourceQueryDTO{name = " + name + ", url = " + url + ", categoryId = " + categoryId + ", createBy = " + createBy + ", updateBy = " + updateBy + ", startTime = " + startTime + ", endTime = " + endTime + "}";
    }
}
