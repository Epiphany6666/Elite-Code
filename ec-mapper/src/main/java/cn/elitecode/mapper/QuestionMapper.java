package cn.elitecode.mapper;

import cn.elitecode.model.dto.question.QuestionQueryDTO;
import cn.elitecode.model.entity.Question;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
* question(题目表)
*/
public interface QuestionMapper {

    /**
     * 插入题库
     * @param question
     * @return
     */
    int insertQuestion(Question question);

    /**
     * 批量删除题目
     * @param questionIds
     * @return
     */
    int deleteByQuestionIds(@Param("questionIds") Long[] questionIds);

    /**
     * 根据主键动态更新题目信息
     * @param question
     */
    void updateQuestionById(Question question);

    /**
     * 根据id查询题目信息
     * @param questionId
     * @return
     */
    Question selectQuestionById(Long questionId);

    /**
     * 根据条件分页查询题目列表
     * @param questionQueryDTO
     * @return
     */
    List<Question> selectQuestionList(QuestionQueryDTO questionQueryDTO);

    /**
     * 获取总条数
     * @param questionQueryDTO
     * @return
     */
    Long getQuestionTotal(QuestionQueryDTO questionQueryDTO);
}




