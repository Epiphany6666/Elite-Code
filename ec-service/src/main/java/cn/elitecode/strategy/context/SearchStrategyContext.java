package cn.elitecode.strategy.context;

import cn.elitecode.common.api.CommonPage;
import cn.elitecode.enums.SearchModeEnum;
import cn.elitecode.model.dto.question.QuestionQueryDTO;
import cn.elitecode.model.dto.elasticsearch.QuestionSearchDTO;
import cn.elitecode.strategy.SearchStrategy;
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

    public CommonPage<QuestionSearchDTO> executeSearchStrategy(QuestionQueryDTO questionQueryDTO) {
        return searchStrategyMap.get(SearchModeEnum.getStrategy(mode)).selectQuestionList(questionQueryDTO);
    }
}
