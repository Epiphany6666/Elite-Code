package cn.elitecode.mapper;

import cn.elitecode.model.dto.problemset.ProblemsetQueryQuestionDTO;
import cn.elitecode.model.dto.question.QuestionQueryDTO;
import cn.elitecode.model.entity.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
* question(题目表)
*/
@Mapper
public interface QuestionMapper {

    /**
     * 插入题目
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

    /**
     * 根据分页条件查询所在题库的题目信息
     * @param problemsetQueryQuestionDTO
     * @return
     */
    List<Question> selectProblemsetQuestionList(ProblemsetQueryQuestionDTO problemsetQueryQuestionDTO);

    /**
     * 根据分页条件查询所在题库的题目总数
     * @param problemsetQueryQuestionDTO
     * @return
     */
    Long selectProblemsetQuestionTotal(ProblemsetQueryQuestionDTO problemsetQueryQuestionDTO);

    /**
     * 查询所有题目
     * @return
     */
    List<Question> getAllQuestionList();
}




