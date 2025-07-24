package cn.elitecode.module.resume.service.search;

import cn.elitecode.framework.common.pojo.CommonPage;
import cn.elitecode.module.resume.controller.admin.question.vo.QuestionQueryReqVO;
import cn.elitecode.module.resume.dal.dataobject.question.QuestionDO;
import cn.elitecode.module.resume.dal.mysql.question.QuestionMapper;
import cn.elitecode.module.resume.strategy.SearchStrategy;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MySqlSearchStrategyImpl implements SearchStrategy {

    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public CommonPage<QuestionDO> selectQuestionList(QuestionQueryReqVO questionQueryReqVO) {
        if (questionQueryReqVO.getCurrent() != null && questionQueryReqVO.getPageSize() != null) {
            questionQueryReqVO.setCurrent((questionQueryReqVO.getCurrent() - 1) * questionQueryReqVO.getPageSize());
        }
        List<QuestionDO> questionDOList = questionMapper.selectQuestionList(questionQueryReqVO);
        Long total = questionMapper.getQuestionTotal(questionQueryReqVO);
        List<QuestionDO> result = questionDOList.stream().map(item -> {
            QuestionDO questionDO = new QuestionDO();
            BeanUtils.copyProperties(item, questionDO);
            return questionDO;
        }).toList();
        CommonPage<QuestionDO> page = new CommonPage<>(total, result);
        return page;
    }

}
