package cn.elitecode.module.system.controller.admin.dict.vo.type;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

public class DictTypeUpdateReqVO {
    @ApiModelProperty(value = "字典类型ID，主键")
    @NotNull(message = "字典类型ID不能为空")
    private Long id;
    @ApiModelProperty(value = "字典名称")
    private String name;
    @ApiModelProperty(value = "字典类型")
    private String type;
    @ApiModelProperty(value = "状态（0正常 1停用）")
    private Integer status;
    @ApiModelProperty(value = "备注")
    private String remark;

    public DictTypeUpdateReqVO() {
    }

    public DictTypeUpdateReqVO(Long id, String name, String type, Integer status, String remark) {
        this.id = id;
        this.name = name;
        this.type = type;
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
        return "DictTypeUpdateReqVO{id = " + id + ", name = " + name + ", type = " + type + ", status = " + status + ", remark = " + remark + "}";
    }
}
