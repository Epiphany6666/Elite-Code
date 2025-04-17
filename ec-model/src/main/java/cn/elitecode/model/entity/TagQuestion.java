package cn.elitecode.model.entity;

import io.swagger.annotations.ApiModelProperty;

/**
* tag_question(题目和标签关联表) | 实体类
* @TableName
*/
public class TagQuestion {

    @ApiModelProperty("题目ID（外键，关联题目表ID）")
    private Long questionId;

    @ApiModelProperty("标签ID（外键，关联标签表ID）")
    private Long tagId;

    public TagQuestion() {
    }

    public TagQuestion(Long questionId, Long tagId) {
        this.questionId = questionId;
        this.tagId = tagId;
    }

    /**
    * 题目ID（外键，关联题目表ID）
    */
    public void setQuestionId(Long questionId){
    this.questionId = questionId;
    }

    /**
    * 标签ID（外键，关联标签表ID）
    */
    public void setTagId(Long tagId){
    this.tagId = tagId;
    }


    /**
    * 题目ID（外键，关联题目表ID）
    */
    public Long getQuestionId(){
    return this.questionId;
    }

    /**
    * 标签ID（外键，关联标签表ID）
    */
    public Long getTagId(){
    return this.tagId;
    }

    public String toString() {
        return "TagQuestion{questionId = " + questionId + ", tagId = " + tagId + "}";
    }
}
