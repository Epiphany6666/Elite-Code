package cn.elitecode.module.resume.strategy;

import cn.elitecode.framework.common.pojo.CommonPage;
import cn.elitecode.module.resume.controller.admin.question.vo.QuestionQueryDTO;
import cn.elitecode.module.resume.controller.admin.question.vo.QuestionSearchDTO;

public interface SearchStrategy {

    /**
     * 根据分页条件获取题目信息
     * @param questionQueryDTO
     * @return
     */
    CommonPage<QuestionSearchDTO> selectQuestionList(QuestionQueryDTO questionQueryDTO);
}
