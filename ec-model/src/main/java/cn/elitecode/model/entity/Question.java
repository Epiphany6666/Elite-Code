package cn.elitecode.model.entity;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
* question(题目表) | 实体类
*/
public class Question {

    @ApiModelProperty("用户ID，主键")
    private Long id;

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("内容")
    private String content;

    @ApiModelProperty("推荐答案")
    private String answer;

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

    public Question() {
    }

    public Question(Long id, String title, String content, String answer, String delFlag, Long createBy, Date createTime, Long updateBy, Date updateTime) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.answer = answer;
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
    * 内容
    */
    public void setContent(String content){
    this.content = content;
    }

    /**
    * 推荐答案
    */
    public void setAnswer(String answer){
    this.answer = answer;
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
    * 内容
    */
    public String getContent(){
    return this.content;
    }

    /**
    * 推荐答案
    */
    public String getAnswer(){
    return this.answer;
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
        return "Question{id = " + id + ", title = " + title + ", content = " + content + ", answer = " + answer + ", delFlag = " + delFlag + ", createBy = " + createBy + ", createTime = " + createTime + ", updateBy = " + updateBy + ", updateTime = " + updateTime + "}";
    }

}
