package cn.elitecode.service;

import cn.elitecode.common.api.CommonPage;
import cn.elitecode.model.dto.problemset.ProblemsetQueryQuestionDTO;
import cn.elitecode.model.dto.question.QuestionAddDTO;
import cn.elitecode.model.dto.question.QuestionQueryDTO;
import cn.elitecode.model.dto.question.QuestionUpdateDTO;
import cn.elitecode.model.entity.Question;

/**
* question(题目题表) | 业务层
*/
public interface QuestionService {

    /**
     * 新增题目
     * @param questionAddDTO
     */
    Long addQuestion(QuestionAddDTO questionAddDTO);

    /**
     * 批量删除题目
     * @param questionIds 需要删除的id数组
     */
    void removeByQuestionIds(Long[] questionIds);

    /**
     * 根据id更新题目信息
     * @param questionUpdateDTO
     */
    void updateQuestion(QuestionUpdateDTO questionUpdateDTO);

    /**
     * 根据id查询题目信息
     * @param questionId
     * @return
     */
    Question selectQuestionById(Long questionId);

    /**
     * 根据分页条件获取题目信息
     * @param questionQueryDTO
     * @return
     */
    CommonPage<Question> selectQuestionList(QuestionQueryDTO questionQueryDTO);

    /**
     * 根据分页条件查询所在题库的题目信息
     * @param problemsetQueryQuestionDTO
     * @return
     */
    CommonPage<Question> selectProblemsetQuestionList(ProblemsetQueryQuestionDTO problemsetQueryQuestionDTO);
}
