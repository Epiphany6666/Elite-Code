package cn.elitecode.strategy;

import cn.elitecode.common.api.CommonPage;
import cn.elitecode.model.dto.question.QuestionQueryDTO;
import cn.elitecode.model.dto.elasticsearch.QuestionSearchDTO;

public interface SearchStrategy {

    /**
     * 根据分页条件获取题目信息
     * @param questionQueryDTO
     * @return
     */
    CommonPage<QuestionSearchDTO> selectQuestionList(QuestionQueryDTO questionQueryDTO);
}
