package cn.elitecode.service.impl;

import cn.elitecode.common.api.CommonPage;
import cn.elitecode.common.utils.SecurityUtils;
import cn.elitecode.mapper.ProblemsetQuestionMapper;
import cn.elitecode.mapper.QuestionMapper;
import cn.elitecode.model.dto.problemset.ProblemsetQueryQuestionDTO;
import cn.elitecode.model.dto.question.QuestionAddDTO;
import cn.elitecode.model.dto.question.QuestionQueryDTO;
import cn.elitecode.model.dto.question.QuestionUpdateDTO;
import cn.elitecode.model.entity.ProblemsetQuestion;
import cn.elitecode.model.entity.Question;
import cn.elitecode.service.QuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
* question(题目题表) | 业务处理层
*/
@Service
public class QuestionServiceImpl implements QuestionService{

    private static final Logger log = LoggerFactory.getLogger(QuestionServiceImpl.class);

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private ProblemsetQuestionMapper problemsetQuestionMapper;

    @Override
    @Transactional
    public Long addQuestion(QuestionAddDTO questionAddDTO) {
        // 新增题目信息
        Question question = new Question();
        BeanUtils.copyProperties(questionAddDTO, question);
        question.setCreateBy(SecurityUtils.getUserId());
        questionMapper.insertQuestion(question);

        // 新增题库题目关联
        insertProblemsetQuestion(question.getId(), questionAddDTO.getProblemsetIds());
        return question.getId();
    }

    @Override
    @Transactional
    public void removeByQuestionIds(Long[] questionIds) {
        // 从题目表删除题目
        questionMapper.deleteByQuestionIds(questionIds);
        // 删除题库题目关联
        problemsetQuestionMapper.deleteProblemsetQuestionByQuestionIds(questionIds);

    }

    @Override
    @Transactional
    public void updateQuestion(QuestionUpdateDTO questionUpdateDTO) {
        // 修改题目信息
        Question question = new Question();
        BeanUtils.copyProperties(questionUpdateDTO, question);
        question.setUpdateBy(SecurityUtils.getUserId());
        questionMapper.updateQuestionById(question);

        // 删除题目与题库关联
        problemsetQuestionMapper.deleteProblemsetQuestionByQuestionId(questionUpdateDTO.getId());

        // 新增题目与题库关联
        insertProblemsetQuestion(questionUpdateDTO.getId(), questionUpdateDTO.getProblemsetIds());
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

    @Override
    public CommonPage<Question> selectProblemsetQuestionList(ProblemsetQueryQuestionDTO problemsetQueryQuestionDTO) {
        List<Question> questionList = questionMapper.selectProblemsetQuestionList(problemsetQueryQuestionDTO);
        Long total = questionMapper.selectProblemsetQuestionTotal(problemsetQueryQuestionDTO);
        CommonPage<Question> page = new CommonPage<>(total, questionList);
        return page;
    }

    /**
     * 新增题库题目关联
     * @param questionId
     * @param problemsetIds
     */
    private void insertProblemsetQuestion(Long questionId, List<Long> problemsetIds) {
        List<ProblemsetQuestion> problemsetQuestionList = new ArrayList<>();
        for (Long problemsetId : problemsetIds) {
            problemsetQuestionList.add(new ProblemsetQuestion(problemsetId, questionId));
        }
        problemsetQuestionMapper.batchProblemsetQuestion(problemsetQuestionList);
    }

}




