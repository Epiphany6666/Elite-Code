package cn.elitecode.module.system.controller.admin.dict.vo.type;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class DictTypeAddReqVO {

    @ApiModelProperty(value = "字典名称")
    @NotEmpty(message = "字典名称不能为空")
    private String name;
    @ApiModelProperty(value = "字典类型")
    @NotEmpty(message = "字典类型不能为空")
    private String type;
    @ApiModelProperty(value = "状态（0正常 1停用）")
    @NotNull(message = "状态不能为空")
    private Integer status;
    @ApiModelProperty(value = "备注")
    private String remark;

    public DictTypeAddReqVO() {
    }

    public DictTypeAddReqVO(String name, String type, Integer status, String remark) {
        this.name = name;
        this.type = type;
        this.status = status;
        this.remark = remark;
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
        return "DictTypeAddReqVO{name = " + name + ", type = " + type + ", status = " + status + ", remark = " + remark + "}";
    }
}
