package cn.elitecode.module.system.controller.admin.dict.vo.data;

import cn.elitecode.framework.common.pojo.PageRequest;
import io.swagger.annotations.ApiModelProperty;

public class DictDataPageReqVO extends PageRequest {

    @ApiModelProperty(value = "字典标签")
    private String label;
    @ApiModelProperty(value = "字典类型")
    private String dictType;
    @ApiModelProperty(value = "状态（0正常 1停用）")
    private Integer status;

    public DictDataPageReqVO() {
    }

    public DictDataPageReqVO(String label, String dictType, Integer status) {
        this.label = label;
        this.dictType = dictType;
        this.status = status;
    }

    /**
     * 获取
     * @return label
     */
    public String getLabel() {
        return label;
    }

    /**
     * 设置
     * @param label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * 获取
     * @return dictType
     */
    public String getDictType() {
        return dictType;
    }

    /**
     * 设置
     * @param dictType
     */
    public void setDictType(String dictType) {
        this.dictType = dictType;
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

    public String toString() {
        return "DictDataPageReqVO{label = " + label + ", dictType = " + dictType + ", status = " + status + "}";
    }
}
