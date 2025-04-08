package cn.elitecode.model.dto.question;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

public class QuestionUpdateDTO {

    @ApiModelProperty("用户ID，主键")
    @NotNull(message = "题目id不能为空")
    private Long id;

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("内容")
    private String content;

    @ApiModelProperty("推荐答案")
    private String answer;

    public QuestionUpdateDTO() {
    }

    public QuestionUpdateDTO(Long id, String title, String content, String answer) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.answer = answer;
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

    public String toString() {
        return "QuestionUpdateDTO{id = " + id + ", title = " + title + ", content = " + content + ", answer = " + answer + "}";
    }

}
