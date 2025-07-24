package cn.elitecode.module.resume.controller.admin.question.vo;

import cn.elitecode.module.resume.dal.dataobject.problemset.ProblemsetDO;
import cn.elitecode.module.resume.dal.dataobject.question.QuestionDO;
import cn.elitecode.module.resume.dal.dataobject.tag.TagDO;

import java.util.List;

public class QuestionQueryRespVO {
    private QuestionDO question;
    private List<Long> problemsetIds;
    private List<ProblemsetDO> problemsetAll;
    private List<Long> tagIds;
    private List<TagDO> tagAll;

    public QuestionQueryRespVO() {
    }

    public QuestionQueryRespVO(QuestionDO question, List<Long> problemsetIds, List<ProblemsetDO> problemsetAll, List<Long> tagIds, List<TagDO> tagAll) {
        this.question = question;
        this.problemsetIds = problemsetIds;
        this.problemsetAll = problemsetAll;
        this.tagIds = tagIds;
        this.tagAll = tagAll;
    }

    public QuestionDO getQuestion() {
        return question;
    }

    public void setQuestion(QuestionDO question) {
        this.question = question;
    }

    public List<Long> getProblemsetIds() {
        return problemsetIds;
    }

    public void setProblemsetIds(List<Long> problemsetIds) {
        this.problemsetIds = problemsetIds;
    }

    public List<ProblemsetDO> getProblemsetAll() {
        return problemsetAll;
    }

    public void setProblemsetAll(List<ProblemsetDO> problemsetAll) {
        this.problemsetAll = problemsetAll;
    }

    public List<Long> getTagIds() {
        return tagIds;
    }

    public void setTagIds(List<Long> tagIds) {
        this.tagIds = tagIds;
    }

    public List<TagDO> getTagAll() {
        return tagAll;
    }

    public void setTagAll(List<TagDO> tagAll) {
        this.tagAll = tagAll;
    }
}
