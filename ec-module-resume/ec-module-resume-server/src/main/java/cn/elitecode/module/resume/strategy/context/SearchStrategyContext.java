package cn.elitecode.module.resume.strategy.context;

import cn.elitecode.framework.common.pojo.CommonPage;
import cn.elitecode.module.resume.controller.admin.question.vo.QuestionQueryReqVO;
import cn.elitecode.module.resume.dal.dataobject.question.QuestionDO;
import cn.elitecode.module.resume.enums.SearchModeEnum;
import cn.elitecode.module.resume.strategy.SearchStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SearchStrategyContext {

    @Value("${elitecode.search.mode}")
    private String mode;

    @Autowired
    private Map<String, SearchStrategy> searchStrategyMap;

    public CommonPage<QuestionDO> executeSearchStrategy(QuestionQueryReqVO questionQueryReqVO) {
        return searchStrategyMap.get(SearchModeEnum.getStrategy(mode)).selectQuestionList(questionQueryReqVO);
    }
}
