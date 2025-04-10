package cn.elitecode.model.dto.problemset;

import cn.elitecode.common.PageRequest;
import io.swagger.annotations.ApiModelProperty;

public class ProblemsetQueryQuestionDTO extends PageRequest {

    @ApiModelProperty("题目id")
    private Long id;

    @ApiModelProperty("题目标题")
    private String title;

    @ApiModelProperty("题目内容")
    private String content;

    public ProblemsetQueryQuestionDTO() {
    }

    public ProblemsetQueryQuestionDTO(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
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

    public String toString() {
        return "ProblemsetQueryQuestionDTO{id = " + id + ", title = " + title + ", content = " + content + "}";
    }
}
