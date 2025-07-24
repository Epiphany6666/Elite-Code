package cn.elitecode.module.resume.strategy;

import cn.elitecode.framework.common.pojo.CommonPage;
import cn.elitecode.module.resume.controller.admin.question.vo.QuestionQueryReqVO;
import cn.elitecode.module.resume.dal.dataobject.question.QuestionDO;

public interface SearchStrategy {

    /**
     * 根据分页条件获取题目信息
     * @param questionQueryReqVO
     * @return
     */
    CommonPage<QuestionDO> selectQuestionList(QuestionQueryReqVO questionQueryReqVO);
}
