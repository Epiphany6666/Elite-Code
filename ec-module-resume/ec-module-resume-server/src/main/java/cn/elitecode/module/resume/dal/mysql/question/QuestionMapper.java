package cn.elitecode.module.resume.dal.mysql.question;

import cn.elitecode.module.resume.controller.admin.problemset.vo.ProblemsetQueryQuestionReqVO;
import cn.elitecode.module.resume.controller.admin.question.vo.QuestionQueryDTO;
import cn.elitecode.module.resume.dal.dataobject.question.QuestionDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* resume_question(题目表)
*/
@Mapper
public interface QuestionMapper {

    /**
     * 插入题目
     * @param questionDO
     * @return
     */
    int insertQuestion(QuestionDO questionDO);

    /**
     * 批量删除题目
     * @param questionIds
     * @return
     */
    int deleteByQuestionIds(@Param("questionIds") Long[] questionIds);

    /**
     * 根据主键动态更新题目信息
     * @param questionDO
     */
    void updateQuestionById(QuestionDO questionDO);

    /**
     * 根据id查询题目信息
     * @param questionId
     * @return
     */
    QuestionDO selectQuestionById(Long questionId);

    /**
     * 根据条件分页查询题目列表
     * @param questionQueryDTO
     * @return
     */
    List<QuestionDO> selectQuestionList(QuestionQueryDTO questionQueryDTO);

    /**
     * 获取总条数
     * @param questionQueryDTO
     * @return
     */
    Long getQuestionTotal(QuestionQueryDTO questionQueryDTO);

    /**
     * 根据分页条件查询所在题库的题目信息
     * @param problemsetQueryQuestionReqVO
     * @return
     */
    List<QuestionDO> selectProblemsetQuestionList(ProblemsetQueryQuestionReqVO problemsetQueryQuestionReqVO);

    /**
     * 根据分页条件查询所在题库的题目总数
     * @param problemsetQueryQuestionReqVO
     * @return
     */
    Long selectProblemsetQuestionTotal(ProblemsetQueryQuestionReqVO problemsetQueryQuestionReqVO);

    /**
     * 查询所有题目
     * @return
     */
    List<QuestionDO> getAllQuestionList();
}




