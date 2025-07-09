package cn.elitecode.module.resume.dal.dataobject.question;

import io.swagger.annotations.ApiModelProperty;

/**
* resume_problemset_question_relation(题目与题库关联表) | 实体类
*/
public class ProblemsetQuestionDO {

    @ApiModelProperty("题库id")
    private Long problemsetId;

    @ApiModelProperty("题目id")
    private Long questionId;

    public ProblemsetQuestionDO() {
    }

    public ProblemsetQuestionDO(Long problemsetId, Long questionId) {
        this.problemsetId = problemsetId;
        this.questionId = questionId;
    }

    /**
    * 题库id
    */
    public void setProblemsetId(Long problemsetId){
    this.problemsetId = problemsetId;
    }

    /**
    * 题目id
    */
    public void setQuestionId(Long questionId){
    this.questionId = questionId;
    }


    /**
    * 题库id
    */
    public Long getProblemsetId(){
    return this.problemsetId;
    }

    /**
    * 题目id
    */
    public Long getQuestionId(){
    return this.questionId;
    }

    public String toString() {
        return "ProblemsetQuestionDO{problemsetId = " + problemsetId + ", questionId = " + questionId + "}";
    }

}
