package cn.elitecode.module.resume.dal.mysql.question;

import cn.elitecode.module.resume.dal.dataobject.question.TagQuestionDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* resume_tag_question_relation(题目和标签关联表)
*/
@Mapper
public interface TagQuestionMapper {

    /**
     * 根据 题目id 删除标签题目关联
     * @param questionId
     */
    void deleteTagQuestionByQuestionId(Long questionId);

    /**
     * 批量插入标签题目关联
     * @param tagQuestionsListDO
     */
    void batchTagQuestion(@Param("tagQuestionsListDO") List<TagQuestionDO> tagQuestionsListDO);

    /**
     * 根据 题目id列表 删除标签题目关联
     * @param questionIds
     */
    void deleteTagQuestionByQuestionIds(@Param("questionIds") Long[] questionIds);
}




