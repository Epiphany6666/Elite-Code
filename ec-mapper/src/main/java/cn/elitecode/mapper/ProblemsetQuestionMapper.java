package cn.elitecode.mapper;

import cn.elitecode.model.entity.ProblemsetQuestion;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
* problemset_question(题目与题库关联表)
*/
@Mapper
public interface ProblemsetQuestionMapper {

    /**
     * 批量添加题库题目关联
     * @param problemsetQuestionList
     */
    void batchProblemsetQuestion(@Param("problemsetQuestionList") List<ProblemsetQuestion> problemsetQuestionList);

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




