package cn.elitecode.model.dto.question;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotEmpty;

public class QuestionAddDTO {

    @ApiModelProperty("标题")
    @NotEmpty(message = "标题不能为空")
    private String title;

    @ApiModelProperty("内容")
    @NotEmpty(message = "内容不能为空")
    private String content;

    @ApiModelProperty("推荐答案")
    private String answer;

    public QuestionAddDTO() {
    }

    public QuestionAddDTO(String title, String content, String answer) {
        this.title = title;
        this.content = content;
        this.answer = answer;
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

    public String toString() {
        return "QuestionAddDTO{title = " + title + ", content = " + content + ", answer = " + answer + "}";
    }
}
