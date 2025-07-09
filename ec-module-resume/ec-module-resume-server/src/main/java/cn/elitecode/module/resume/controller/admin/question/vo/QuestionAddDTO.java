package cn.elitecode.module.resume.controller.admin.question.vo;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotEmpty;
import java.util.List;

public class QuestionAddDTO {

    @ApiModelProperty(value = "标题", required = true)
    @NotEmpty(message = "标题不能为空")
    private String title;

    @ApiModelProperty(value = "内容", required = true)
    @NotEmpty(message = "内容不能为空")
    private String content;

    @ApiModelProperty("推荐答案")
    private String answer;

    @ApiModelProperty("题库id列表")
    private List<Long> problemsetIds;

    @ApiModelProperty("标签id列表")
    private List<Long> tagIds;

    public QuestionAddDTO() {
    }

    public QuestionAddDTO(String title, String content, String answer, List<Long> problemsetIds, List<Long> tagIds) {
        this.title = title;
        this.content = content;
        this.answer = answer;
        this.problemsetIds = problemsetIds;
        this.tagIds = tagIds;
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
     * @return problemsetIds
     */
    public List<Long> getProblemsetIds() {
        return problemsetIds;
    }

    /**
     * 设置
     * @param problemsetIds
     */
    public void setProblemsetIds(List<Long> problemsetIds) {
        this.problemsetIds = problemsetIds;
    }

    /**
     * 获取
     * @return tagIds
     */
    public List<Long> getTagIds() {
        return tagIds;
    }

    /**
     * 设置
     * @param tagIds
     */
    public void setTagIds(List<Long> tagIds) {
        this.tagIds = tagIds;
    }

    public String toString() {
        return "QuestionAddDTO{title = " + title + ", content = " + content + ", answer = " + answer + ", problemsetIds = " + problemsetIds + ", tagIds = " + tagIds + "}";
    }
}
