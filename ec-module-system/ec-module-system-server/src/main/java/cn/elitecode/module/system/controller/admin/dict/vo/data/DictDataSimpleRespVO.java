package cn.elitecode.module.system.controller.admin.dict.vo.data;

import io.swagger.annotations.ApiModelProperty;

public class DictDataSimpleRespVO {

    @ApiModelProperty(value = "字典排序")
    private Integer sort;
    @ApiModelProperty(value = "字典标签")
    private String label;
    @ApiModelProperty(value = "字典键值")
    private String value;
    @ApiModelProperty(value = "字典类型")
    private String dictType;

    public DictDataSimpleRespVO() {
    }

    public DictDataSimpleRespVO(Integer sort, String label, String value, String dictType) {
        this.sort = sort;
        this.label = label;
        this.value = value;
        this.dictType = dictType;
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

    public String toString() {
        return "DictDataSimpleRespVO{sort = " + sort + ", label = " + label + ", value = " + value + ", dictType = " + dictType + "}";
    }
}
