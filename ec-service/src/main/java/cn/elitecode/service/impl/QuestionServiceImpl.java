package cn.elitecode.service.impl;

import cn.elitecode.common.api.CommonPage;
import cn.elitecode.common.utils.SecurityUtils;
import cn.elitecode.mapper.QuestionMapper;
import cn.elitecode.model.dto.question.QuestionQueryDTO;
import cn.elitecode.model.entity.Question;
import cn.elitecode.service.QuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
* question(题目题表) | 业务处理层
*/
@Service
public class QuestionServiceImpl implements QuestionService{

    private static final Logger log = LoggerFactory.getLogger(QuestionServiceImpl.class);

    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public Long addQuestion(Question question) {
        int result = questionMapper.insertQuestion(question);
        if (result <= 0) {
            log.error("插入题目失败：{}", result);
        }
        return question.getId();
    }

    @Override
    public void removeByQuestionIds(Long[] questionIds) {
        int result = questionMapper.deleteByQuestionIds(questionIds);
        if (result <= 0) {
            log.error("批量删除题目失败：{}", result);
        }
    }

    @Override
    public void updateQuestion(Question question) {
        question.setUpdateBy(SecurityUtils.getUserId());
        questionMapper.updateQuestionById(question);
    }

    @Override
    public Question selectQuestionById(Long questionId) {
        Question question = questionMapper.selectQuestionById(questionId);
        return question;
    }

    @Override
    public CommonPage<Question> selectQuestionList(QuestionQueryDTO questionQueryDTO) {
        if (questionQueryDTO.getCurrent() != null && questionQueryDTO.getPageSize() != null) {
            questionQueryDTO.setCurrent((questionQueryDTO.getCurrent() - 1) * questionQueryDTO.getPageSize());
        }
        List<Question> questionList = questionMapper.selectQuestionList(questionQueryDTO);
        Long total = questionMapper.getQuestionTotal(questionQueryDTO);
        CommonPage<Question> page = new CommonPage<>(total, questionList);
        return page;
    }

}




