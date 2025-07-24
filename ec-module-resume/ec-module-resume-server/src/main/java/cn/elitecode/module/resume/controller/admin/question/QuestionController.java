package cn.elitecode.module.resume.controller.admin.question;

import cn.elitecode.framework.common.pojo.CommonPage;
import cn.elitecode.framework.common.pojo.CommonResult;
import cn.elitecode.module.resume.controller.admin.question.vo.QuestionAddReqVO;
import cn.elitecode.module.resume.controller.admin.question.vo.QuestionQueryReqVO;
import cn.elitecode.module.resume.controller.admin.question.vo.QuestionQueryRespVO;
import cn.elitecode.module.resume.controller.admin.question.vo.QuestionUpdateReqVO;
import cn.elitecode.module.resume.dal.dataobject.problemset.ProblemsetDO;
import cn.elitecode.module.resume.dal.dataobject.question.QuestionDO;
import cn.elitecode.module.resume.dal.dataobject.tag.TagDO;
import cn.elitecode.module.resume.dal.mysql.question.EsQuestionMapper;
import cn.elitecode.module.resume.dal.mysql.question.QuestionMapper;
import cn.elitecode.module.resume.service.problemset.ProblemsetService;
import cn.elitecode.module.resume.service.question.QuestionService;
import cn.elitecode.module.resume.service.tag.TagService;
import cn.elitecode.module.resume.strategy.context.SearchStrategyContext;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Api(tags = "QuestionController", description = "题目管理")
@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;
    @Autowired
    private SearchStrategyContext searchStrategyContext;
    @Autowired
    private ProblemsetService problemsetService;
    @Autowired
    private TagService tagService;
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private EsQuestionMapper esQuestionMapper;

    @ApiOperation(value = "根据分页条件查询题目信息")
    @PostMapping("/list")
    private CommonResult<CommonPage<QuestionDO>> listQuestion(@RequestBody QuestionQueryReqVO questionQueryReqVO) {
        return CommonResult.success(searchStrategyContext.executeSearchStrategy(questionQueryReqVO));
    }

    @ApiOperation(value = "新增题目")
    @PostMapping
    private CommonResult<Long> addQuestion(@Validated @RequestBody QuestionAddReqVO questionAddReqVO) {
        Long questionId = questionService.addQuestion(questionAddReqVO);
        return CommonResult.success(questionId);
    }

    @ApiOperation(value = "根据id查询题目信息")
    @GetMapping({"/", "/{questionId}"})
    private CommonResult<QuestionQueryRespVO> getQuestion(@PathVariable(value = "questionId", required = false) Long questionId) {
        QuestionQueryRespVO queryRespVO = new QuestionQueryRespVO();
        if (questionId != null) {
            QuestionDO questionDO = questionService.selectQuestionById(questionId);
            queryRespVO.setQuestion(questionDO);
            List<Long> problemsetIds = questionDO.getProblemsetList().stream().map(ProblemsetDO::getId).toList();
            queryRespVO.setProblemsetIds(problemsetIds);
            List<Long> tagIds = questionDO.getTagList().stream().map(TagDO::getId).toList();
            queryRespVO.setTagIds(tagIds);
        }
        List<ProblemsetDO> problemsetDOAll = problemsetService.selectProblemsetAll();
        queryRespVO.setProblemsetAll(problemsetDOAll);
        List<TagDO> tagDOAll = tagService.selectTagAll();
        queryRespVO.setTagAll(tagDOAll);
        return CommonResult.success(queryRespVO);
    }

    @ApiOperation(value = "根据id更新题目信息")
    @PutMapping
    private CommonResult updateQuestion(@Validated @RequestBody QuestionUpdateReqVO questionUpdateReqVO) {
        questionService.updateQuestion(questionUpdateReqVO);
        return CommonResult.success();
    }

    @ApiOperation(value = "批量删除题目")
    @DeleteMapping("/{questionIds}")
    private CommonResult removeQuestions(@ApiParam("需要删除的id数组") @PathVariable Long[] questionIds) {
        questionService.removeByQuestionIds(questionIds);
        return CommonResult.success();
    }

    @ApiOperation(value = "导入全部MySql数据到ES")
    @PostMapping("/importAll")
    private CommonResult importAll() {
        List<QuestionDO> allQuestionDOList = questionMapper.getAllQuestionList();
        esQuestionMapper.saveAll(allQuestionDOList.stream().map(item -> {
            QuestionDO questionDO = new QuestionDO();
            BeanUtils.copyProperties(item, questionDO);
            return questionDO;
        }).collect(Collectors.toList()));
        return CommonResult.success();
    }

}
