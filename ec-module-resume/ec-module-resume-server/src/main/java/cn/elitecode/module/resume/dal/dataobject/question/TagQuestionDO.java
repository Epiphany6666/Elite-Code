package cn.elitecode.module.resume.dal.dataobject.question;

import io.swagger.annotations.ApiModelProperty;

/**
* resume_tag_question_relation(题目和标签关联表) | 实体类
* @TableName
*/
public class TagQuestionDO {

    @ApiModelProperty("题目ID（外键，关联题目表ID）")
    private Long questionId;

    @ApiModelProperty("标签ID（外键，关联标签表ID）")
    private Long tagId;

    public TagQuestionDO() {
    }

    public TagQuestionDO(Long questionId, Long tagId) {
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
        return "TagQuestionDO{questionId = " + questionId + ", tagId = " + tagId + "}";
    }
}
