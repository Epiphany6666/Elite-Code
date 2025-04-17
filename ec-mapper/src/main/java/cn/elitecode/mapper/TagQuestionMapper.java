package cn.elitecode.mapper;

import cn.elitecode.model.entity.TagQuestion;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
* tag_question(题目和标签关联表)
*/
public interface TagQuestionMapper {

    /**
     * 根据 题目id 删除标签题目关联
     * @param questionId
     */
    void deleteTagQuestionByQuestionId(Long questionId);

    /**
     * 批量插入标签题目关联
     * @param tagQuestionsList
     */
    void batchTagQuestion(@Param("tagQuestionsList") List<TagQuestion> tagQuestionsList);

    /**
     * 根据 题目id列表 删除标签题目关联
     * @param questionIds
     */
    void deleteTagQuestionByQuestionIds(@Param("questionIds") Long[] questionIds);
}




