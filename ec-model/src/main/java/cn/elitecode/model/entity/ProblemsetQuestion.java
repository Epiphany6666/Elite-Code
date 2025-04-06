package cn.elitecode.model.entity;

import io.swagger.annotations.ApiModelProperty;

/**
* problemset_question(题目与题库关联表) | 实体类
*/
public class ProblemsetQuestion {

    @ApiModelProperty("题库id")
    private Long problemsetId;

    @ApiModelProperty("题目id")
    private Long questionId;

    public ProblemsetQuestion() {
    }

    public ProblemsetQuestion(Long problemsetId, Long questionId) {
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
        return "ProblemsetQuestion{problemsetId = " + problemsetId + ", questionId = " + questionId + "}";
    }

}
