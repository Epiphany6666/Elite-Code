package cn.elitecode.module.resume.service.question;

import cn.elitecode.framework.common.pojo.CommonPage;
import cn.elitecode.framework.security.core.utils.SecurityUtil;
import cn.elitecode.module.resume.controller.admin.problemset.vo.ProblemsetQueryQuestionReqVO;
import cn.elitecode.module.resume.controller.admin.question.vo.QuestionAddReqVO;
import cn.elitecode.module.resume.controller.admin.question.vo.QuestionUpdateReqVO;
import cn.elitecode.module.resume.controller.app.problemset.vo.AppProblemsetQuestionQueryReqVO;
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
    public Long addQuestion(QuestionAddReqVO questionAddReqVO) {
        // 新增题目信息
        QuestionDO questionDO = new QuestionDO();
        BeanUtils.copyProperties(questionAddReqVO, questionDO);
        questionDO.setCreateBy(SecurityUtil.getUserId());
        questionMapper.insertQuestion(questionDO);

        // 新增题库题目关联
        insertProblemsetQuestion(questionDO.getId(), questionAddReqVO.getProblemsetIds());

        // 新增题目标签关联
        insertTagQuestion(questionDO.getId(), questionAddReqVO.getTagIds());
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
    public void updateQuestion(QuestionUpdateReqVO questionUpdateReqVO) {
        // 修改题目信息
        QuestionDO questionDO = new QuestionDO();
        BeanUtils.copyProperties(questionUpdateReqVO, questionDO);
        questionDO.setUpdateBy(SecurityUtil.getUserId());
        questionMapper.updateQuestionById(questionDO);

        // 删除题目与题库关联
        problemsetQuestionMapper.deleteProblemsetQuestionByQuestionId(questionUpdateReqVO.getId());
        // 新增题目与题库关联
        insertProblemsetQuestion(questionUpdateReqVO.getId(), questionUpdateReqVO.getProblemsetIds());

        // 删除题目与标签关联
        tagQuestionMapper.deleteTagQuestionByQuestionId(questionUpdateReqVO.getId());
        // 新增题目与标签关联
        insertTagQuestion(questionUpdateReqVO.getId(), questionUpdateReqVO.getTagIds());
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

    @Override
    public CommonPage<QuestionDO> selectAppProblemsetQuestionList(AppProblemsetQuestionQueryReqVO appProblemsetQuestionQueryReqVO) {
        if (appProblemsetQuestionQueryReqVO.getCurrent() != null && appProblemsetQuestionQueryReqVO.getPageSize() != null) {
            appProblemsetQuestionQueryReqVO.setCurrent((appProblemsetQuestionQueryReqVO.getCurrent() - 1) * appProblemsetQuestionQueryReqVO.getPageSize());
        }
        List<QuestionDO> questionDOList = questionMapper.selectAppProblemsetQuestionList(appProblemsetQuestionQueryReqVO);
        Long total = questionMapper.selectAppProblemsetQuestionTotal(appProblemsetQuestionQueryReqVO);
        CommonPage<QuestionDO> page = new CommonPage<>(total, questionDOList);
        return page;
    }

    /**
     * 新增题库题目关联
     * @param questionId
     * @param problemsetIds
     */
    private void insertProblemsetQuestion(Long questionId, List<Long> problemsetIds) {
        if (problemsetIds == null && problemsetIds.size() == 0) {
            return;
        }
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




