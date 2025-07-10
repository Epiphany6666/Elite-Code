package cn.elitecode.module.system.controller.admin.dict.vo.data;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class DictDataUpdateReqVO {

    @ApiModelProperty(value = "字典数据ID，主键")
    private Long id;
    @ApiModelProperty(value = "显示顺序")
    @NotNull(message = "显示顺序不能为空")
    private Integer sort;
    @ApiModelProperty(value = "字典标签")
    @NotNull(message = "字典标签不能为空")
    private String label;
    @ApiModelProperty(value = "字典键值")
    @NotEmpty(message = "字典键值不能为空")
    private String value;
    @ApiModelProperty(value = "字典类型")
    @NotEmpty(message = "字典类型不能为空")
    private String dictType;
    @ApiModelProperty(value = "状态（0正常 1停用）")
    @NotNull(message = "状态不能为空")
    private Integer status;
    @ApiModelProperty(value = "备注")
    private String remark;

    public DictDataUpdateReqVO() {
    }

    public DictDataUpdateReqVO(Long id, Integer sort, String label, String value, String dictType, Integer status, String remark) {
        this.id = id;
        this.sort = sort;
        this.label = label;
        this.value = value;
        this.dictType = dictType;
        this.status = status;
        this.remark = remark;
    }

    /**
     * 获取
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取
     * @return sort
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置
     * @param sort
     */
    public void setSort(Integer sort) {
        this.sort = sort;
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
     * @return value
     */
    public String getValue() {
        return value;
    }

    /**
     * 设置
     * @param value
     */
    public void setValue(String value) {
        this.value = value;
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

    /**
     * 获取
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String toString() {
        return "DictDataUpdateReqVO{id = " + id + ", sort = " + sort + ", label = " + label + ", value = " + value + ", dictType = " + dictType + ", status = " + status + ", remark = " + remark + "}";
    }
}
