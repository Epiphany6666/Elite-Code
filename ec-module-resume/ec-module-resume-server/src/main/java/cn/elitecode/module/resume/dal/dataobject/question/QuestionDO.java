package cn.elitecode.module.resume.dal.dataobject.question;

import cn.elitecode.module.resume.dal.dataobject.problemset.ProblemsetDO;
import cn.elitecode.module.resume.dal.dataobject.tag.TagDO;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;
import java.util.List;

/**
* resume_question(题目表) | 实体类
*/
@Document(indexName = "question")
public class QuestionDO {

    @ApiModelProperty("题目ID，主键")
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

    @ApiModelProperty("题库对象列表")
    @Field(type = FieldType.Nested)
    List<ProblemsetDO> problemsetDOList;

    @ApiModelProperty("标签对象列表")
    @Field(type = FieldType.Nested)
    List<TagDO> tagDOList;

    public QuestionDO() {
    }

    public QuestionDO(Long id, String title, String content, String answer, String delFlag, Long createBy, Date createTime, Long updateBy, Date updateTime, List<ProblemsetDO> problemsetDOList, List<TagDO> tagDOList) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.answer = answer;
        this.delFlag = delFlag;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
        this.problemsetDOList = problemsetDOList;
        this.tagDOList = tagDOList;
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
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取
     * @return answer
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * 设置
     * @param answer
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * 获取
     * @return delFlag
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 设置
     * @param delFlag
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * 获取
     * @return createBy
     */
    public Long getCreateBy() {
        return createBy;
    }

    /**
     * 设置
     * @param createBy
     */
    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    /**
     * 获取
     * @return createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取
     * @return updateBy
     */
    public Long getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置
     * @param updateBy
     */
    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 获取
     * @return updateTime
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取
     * @return problemsetDOList
     */
    public List<ProblemsetDO> getProblemsetList() {
        return problemsetDOList;
    }

    /**
     * 设置
     * @param problemsetDOList
     */
    public void setProblemsetList(List<ProblemsetDO> problemsetDOList) {
        this.problemsetDOList = problemsetDOList;
    }

    /**
     * 获取
     * @return tags
     */
    public List<TagDO> getTagList() {
        return tagDOList;
    }

    /**
     * 设置
     * @param tagDOList
     */
    public void setTagList(List<TagDO> tagDOList) {
        this.tagDOList = tagDOList;
    }

    public String toString() {
        return "QuestionDO{id = " + id + ", title = " + title + ", content = " + content + ", answer = " + answer + ", delFlag = " + delFlag + ", createBy = " + createBy + ", createTime = " + createTime + ", updateBy = " + updateBy + ", updateTime = " + updateTime + ", problemsetDOList = " + problemsetDOList + ", tags = " + tagDOList + "}";
    }
}
