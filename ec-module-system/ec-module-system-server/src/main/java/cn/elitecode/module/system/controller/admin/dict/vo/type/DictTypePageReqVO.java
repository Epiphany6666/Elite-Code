package cn.elitecode.module.system.controller.admin.dict.vo.type;

import cn.elitecode.framework.common.pojo.PageRequest;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class DictTypePageReqVO extends PageRequest {

    @ApiModelProperty(value = "字典名称")
    private String name;
    @ApiModelProperty(value = "字典类型")
    private String type;
    @ApiModelProperty(value = "状态（0正常 1停用）")
    private Integer status;
    @ApiModelProperty(value = "开始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    @ApiModelProperty(value = "结束时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    public DictTypePageReqVO() {
    }

    public DictTypePageReqVO(String name, String type, Integer status, Date startTime, Date endTime) {
        this.name = name;
        this.type = type;
        this.status = status;
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
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * 设置
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
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
        return "DictTypePageReqVO{name = " + name + ", type = " + type + ", status = " + status + ", startTime = " + startTime + ", endTime = " + endTime + "}";
    }
}
