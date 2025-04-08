package cn.elitecode.model.dto.question;

import cn.elitecode.common.PageRequest;
import io.swagger.annotations.ApiModelProperty;

/**
 * 题目查询DTO
 */
public class QuestionQueryDTO extends PageRequest {

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "内容")
    private String content;

    public QuestionQueryDTO() {
    }

    public QuestionQueryDTO(String title, String content) {
        this.title = title;
        this.content = content;
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
        return "QuestionQueryDTO{title = " + title + ", content = " + content + "}";
    }
}
