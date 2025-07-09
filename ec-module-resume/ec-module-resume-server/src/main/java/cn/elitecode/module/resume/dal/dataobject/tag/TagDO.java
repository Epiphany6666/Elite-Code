package cn.elitecode.module.resume.dal.dataobject.tag;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
* question_tag(题目标签表) | 实体类
*/
public class TagDO {

    @ApiModelProperty("标签ID，主键")
    private Long id;

    @ApiModelProperty("标签名")
    private String name;

    @ApiModelProperty("删除标志（0代表存在，2代表删除）")
    private String delFlag;

    @ApiModelProperty("创建者")
    private Long createBy;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新者")
    private Long updateBy;

    @ApiModelProperty("编辑时间")
    private Date updateTime;

    public TagDO() {
    }

    public TagDO(Long id, String name, String delFlag, Long createBy, Date createTime, Long updateBy, Date updateTime) {
        this.id = id;
        this.name = name;
        this.delFlag = delFlag;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
    }

    /**
    * 标签ID，主键
    */
    public void setId(Long id){
    this.id = id;
    }

    /**
    * 标签名
    */
    public void setName(String name){
    this.name = name;
    }

    /**
    * 删除标志（0代表存在，2代表删除）
    */
    public void setDelFlag(String delFlag){
    this.delFlag = delFlag;
    }

    /**
    * 创建者
    */
    public void setCreateBy(Long createBy){
    this.createBy = createBy;
    }

    /**
    * 创建时间
    */
    public void setCreateTime(Date createTime){
    this.createTime = createTime;
    }

    /**
    * 更新者
    */
    public void setUpdateBy(Long updateBy){
    this.updateBy = updateBy;
    }

    /**
    * 编辑时间
    */
    public void setUpdateTime(Date updateTime){
    this.updateTime = updateTime;
    }


    /**
    * 标签ID，主键
    */
    public Long getId(){
    return this.id;
    }

    /**
    * 标签名
    */
    public String getName(){
    return this.name;
    }

    /**
    * 删除标志（0代表存在，2代表删除）
    */
    public String getDelFlag(){
    return this.delFlag;
    }

    /**
    * 创建者
    */
    public Long getCreateBy(){
    return this.createBy;
    }

    /**
    * 创建时间
    */
    public Date getCreateTime(){
    return this.createTime;
    }

    /**
    * 更新者
    */
    public Long getUpdateBy(){
    return this.updateBy;
    }

    /**
    * 编辑时间
    */
    public Date getUpdateTime(){
    return this.updateTime;
    }

    public String toString() {
        return "TagDO{id = " + id + ", name = " + name + ", delFlag = " + delFlag + ", createBy = " + createBy + ", createTime = " + createTime + ", updateBy = " + updateBy + ", updateTime = " + updateTime + "}";
    }

}
