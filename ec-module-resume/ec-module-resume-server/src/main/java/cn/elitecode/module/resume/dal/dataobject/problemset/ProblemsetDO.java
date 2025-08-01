package cn.elitecode.module.resume.dal.dataobject.problemset;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
* resume_problemset(题库表) | 实体类
*/
public class ProblemsetDO {

    @ApiModelProperty("用户ID，主键")
    private Long id;

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("图片")
    private String picture;

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

    public ProblemsetDO() {
    }

    public ProblemsetDO(Long id, String title, String description, String picture, String delFlag, Long createBy, Date createTime, Long updateBy, Date updateTime) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.picture = picture;
        this.delFlag = delFlag;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
    }

    /**
    * 用户ID，主键
    */
    public void setId(Long id){
    this.id = id;
    }

    /**
    * 标题
    */
    public void setTitle(String title){
    this.title = title;
    }

    /**
    * 描述
    */
    public void setDescription(String description){
    this.description = description;
    }

    /**
    * 图片
    */
    public void setPicture(String picture){
    this.picture = picture;
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
    * 用户ID，主键
    */
    public Long getId(){
    return this.id;
    }

    /**
    * 标题
    */
    public String getTitle(){
    return this.title;
    }

    /**
    * 描述
    */
    public String getDescription(){
    return this.description;
    }

    /**
    * 图片
    */
    public String getPicture(){
    return this.picture;
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
        return "ProblemsetDO{id = " + id + ", title = " + title + ", description = " + description + ", picture = " + picture + ", delFlag = " + delFlag + ", createBy = " + createBy + ", createTime = " + createTime + ", updateBy = " + updateBy + ", updateTime = " + updateTime + "}";
    }

}
