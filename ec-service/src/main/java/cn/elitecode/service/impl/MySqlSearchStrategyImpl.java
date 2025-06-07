package cn.elitecode.service.impl;

import cn.elitecode.common.api.CommonPage;
import cn.elitecode.mapper.QuestionMapper;
import cn.elitecode.model.dto.question.QuestionQueryDTO;
import cn.elitecode.model.entity.Question;
import cn.elitecode.model.dto.elasticsearch.QuestionSearchDTO;
import cn.elitecode.strategy.SearchStrategy;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MySqlSearchStrategyImpl implements SearchStrategy {

    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public CommonPage<QuestionSearchDTO> selectQuestionList(QuestionQueryDTO questionQueryDTO) {
        if (questionQueryDTO.getCurrent() != null && questionQueryDTO.getPageSize() != null) {
            questionQueryDTO.setCurrent((questionQueryDTO.getCurrent() - 1) * questionQueryDTO.getPageSize());
        }
        List<Question> questionList = questionMapper.selectQuestionList(questionQueryDTO);
        Long total = questionMapper.getQuestionTotal(questionQueryDTO);
        List<QuestionSearchDTO> result = questionList.stream().map(item -> {
            QuestionSearchDTO questionSearchDTO = new QuestionSearchDTO();
            BeanUtils.copyProperties(item, questionSearchDTO);
            return questionSearchDTO;
        }).toList();
        CommonPage<QuestionSearchDTO> page = new CommonPage<>(total, result);
        return page;
    }

}
