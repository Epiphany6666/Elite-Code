package cn.elitecode.module.resume.service.question;

import cn.elitecode.framework.common.pojo.CommonPage;
import cn.elitecode.framework.security.core.utils.SecurityUtil;
import cn.elitecode.module.resume.controller.admin.problemset.vo.ProblemsetQueryQuestionReqVO;
import cn.elitecode.module.resume.controller.admin.question.vo.QuestionAddDTO;
import cn.elitecode.module.resume.controller.admin.question.vo.QuestionUpdateDTO;
import cn.elitecode.module.resume.dal.dataobject.question.ProblemsetQuestionDO;
import cn.elitecode.module.resume.dal.dataobject.question.QuestionDO;
import cn.elitecode.module.resume.dal.dataobject.question.TagQuestionDO;
import cn.elitecode.module.resume.dal.mysql.question.ProblemsetQuestionMapper;
import cn.elitecode.module.resume.dal.mysql.question.QuestionMapper;
import cn.elitecode.module.resume.dal.mysql.question.TagQuestionMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
* resume_question(题目题表) | 业务处理层
*/
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private ProblemsetQuestionMapper problemsetQuestionMapper;
    @Autowired
    private TagQuestionMapper tagQuestionMapper;

    @Override
    @Transactional
    public Long addQuestion(QuestionAddDTO questionAddDTO) {
        // 新增题目信息
        QuestionDO questionDO = new QuestionDO();
        BeanUtils.copyProperties(questionAddDTO, questionDO);
        questionDO.setCreateBy(SecurityUtil.getUserId());
        questionMapper.insertQuestion(questionDO);

        // 新增题库题目关联
        insertProblemsetQuestion(questionDO.getId(), questionAddDTO.getProblemsetIds());
        return questionDO.getId();
    }

    @Override
    @Transactional
    public void removeByQuestionIds(Long[] questionIds) {
        // 从题目表删除题目
        questionMapper.deleteByQuestionIds(questionIds);
        // 删除题库题目关联
        problemsetQuestionMapper.deleteProblemsetQuestionByQuestionIds(questionIds);
        // 删除标签题目关联
        tagQuestionMapper.deleteTagQuestionByQuestionIds(questionIds);
    }

    @Override
    @Transactional
    public void updateQuestion(QuestionUpdateDTO questionUpdateDTO) {
        // 修改题目信息
        QuestionDO questionDO = new QuestionDO();
        BeanUtils.copyProperties(questionUpdateDTO, questionDO);
        questionDO.setUpdateBy(SecurityUtil.getUserId());
        questionMapper.updateQuestionById(questionDO);

        // 删除题目与题库关联
        problemsetQuestionMapper.deleteProblemsetQuestionByQuestionId(questionUpdateDTO.getId());
        // 新增题目与题库关联
        insertProblemsetQuestion(questionUpdateDTO.getId(), questionUpdateDTO.getProblemsetIds());

        // 删除题目与标签关联
        tagQuestionMapper.deleteTagQuestionByQuestionId(questionUpdateDTO.getId());
        // 新增题目与标签关联
        insertTagQuestion(questionUpdateDTO.getId(), questionUpdateDTO.getTagIds());
    }

    @Override
    public QuestionDO selectQuestionById(Long questionId) {
        QuestionDO questionDO = questionMapper.selectQuestionById(questionId);
        return questionDO;
    }

    @Override
    public CommonPage<QuestionDO> selectProblemsetQuestionList(ProblemsetQueryQuestionReqVO problemsetQueryQuestionReqVO) {
        List<QuestionDO> questionDOList = questionMapper.selectProblemsetQuestionList(problemsetQueryQuestionReqVO);
        Long total = questionMapper.selectProblemsetQuestionTotal(problemsetQueryQuestionReqVO);
        CommonPage<QuestionDO> page = new CommonPage<>(total, questionDOList);
        return page;
    }

    /**
     * 新增题库题目关联
     * @param questionId
     * @param problemsetIds
     */
    private void insertProblemsetQuestion(Long questionId, List<Long> problemsetIds) {
        List<ProblemsetQuestionDO> problemsetQuestionDOList = new ArrayList<>();
        for (Long problemsetId : problemsetIds) {
            problemsetQuestionDOList.add(new ProblemsetQuestionDO(problemsetId, questionId));
        }
        problemsetQuestionMapper.batchProblemsetQuestion(problemsetQuestionDOList);
    }


    /**
     * 新增标签题目关联
     * @param questionId
     * @param tagIds
     */
    private void insertTagQuestion(Long questionId, List<Long> tagIds) {
        List<TagQuestionDO> tagQuestionsListDO = new ArrayList<>();
        for (Long tagId : tagIds) {
            tagQuestionsListDO.add(new TagQuestionDO(questionId, tagId));
        }
        tagQuestionMapper.batchTagQuestion(tagQuestionsListDO);
    }

}




