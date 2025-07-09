package cn.elitecode.module.resume.service.question;

import cn.elitecode.framework.common.pojo.CommonPage;
import cn.elitecode.module.resume.controller.admin.problemset.vo.ProblemsetQueryQuestionReqVO;
import cn.elitecode.module.resume.controller.admin.question.vo.QuestionAddDTO;
import cn.elitecode.module.resume.controller.admin.question.vo.QuestionUpdateDTO;
import cn.elitecode.module.resume.dal.dataobject.question.QuestionDO;

/**
* resume_question(题目题表) | 业务层
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
    QuestionDO selectQuestionById(Long questionId);

    /**
     * 根据分页条件查询所在题库的题目信息
     * @param problemsetQueryQuestionReqVO
     * @return
     */
    CommonPage<QuestionDO> selectProblemsetQuestionList(ProblemsetQueryQuestionReqVO problemsetQueryQuestionReqVO);
}
