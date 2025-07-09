package cn.elitecode.module.resume.service.search;

import cn.elitecode.framework.common.pojo.CommonPage;
import cn.elitecode.module.resume.controller.admin.question.vo.QuestionQueryDTO;
import cn.elitecode.module.resume.controller.admin.question.vo.QuestionSearchDTO;
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
    public CommonPage<QuestionSearchDTO> selectQuestionList(QuestionQueryDTO questionQueryDTO) {
        if (questionQueryDTO.getCurrent() != null && questionQueryDTO.getPageSize() != null) {
            questionQueryDTO.setCurrent((questionQueryDTO.getCurrent() - 1) * questionQueryDTO.getPageSize());
        }
        List<QuestionDO> questionDOList = questionMapper.selectQuestionList(questionQueryDTO);
        Long total = questionMapper.getQuestionTotal(questionQueryDTO);
        List<QuestionSearchDTO> result = questionDOList.stream().map(item -> {
            QuestionSearchDTO questionSearchDTO = new QuestionSearchDTO();
            BeanUtils.copyProperties(item, questionSearchDTO);
            return questionSearchDTO;
        }).toList();
        CommonPage<QuestionSearchDTO> page = new CommonPage<>(total, result);
        return page;
    }

}
