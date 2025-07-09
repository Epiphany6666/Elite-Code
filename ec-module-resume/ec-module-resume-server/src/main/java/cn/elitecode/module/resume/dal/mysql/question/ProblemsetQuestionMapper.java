package cn.elitecode.module.resume.dal.mysql.question;

import cn.elitecode.module.resume.dal.dataobject.question.ProblemsetQuestionDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* resume_problemset_question_relation(题目与题库关联表)
*/
@Mapper
public interface ProblemsetQuestionMapper {

    /**
     * 批量添加题库题目关联
     * @param problemsetQuestionDOList
     */
    void batchProblemsetQuestion(@Param("problemsetQuestionDOList") List<ProblemsetQuestionDO> problemsetQuestionDOList);

    /**
     * 根据 题目id 删除题库题目关联
     * @param questionId
     */
    void deleteProblemsetQuestionByQuestionId(Long questionId);

    /**
     * 根据 题目id列表 删除题库题目关联
     * @param questionIds
     */
    void deleteProblemsetQuestionByQuestionIds(@Param("questionIds") Long[] questionIds);

}




