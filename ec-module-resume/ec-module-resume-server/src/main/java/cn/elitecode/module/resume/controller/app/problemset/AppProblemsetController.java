package cn.elitecode.module.resume.controller.app.problemset;

import cn.elitecode.framework.common.pojo.CommonPage;
import cn.elitecode.framework.common.pojo.CommonResult;
import cn.elitecode.module.resume.controller.app.problemset.vo.ProblemsetListRespVO;
import cn.elitecode.module.resume.controller.app.problemset.vo.AppProblemsetQuestionQueryReqVO;
import cn.elitecode.module.resume.controller.app.problemset.vo.AppProblemsetQuestionQueryRespVO;
import cn.elitecode.module.resume.dal.dataobject.problemset.ProblemsetDO;
import cn.elitecode.module.resume.dal.dataobject.question.QuestionDO;
import cn.elitecode.module.resume.service.problemset.ProblemsetService;
import cn.elitecode.module.resume.service.question.QuestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Api(tags = "AppProblemsetController", description = "用户 APP - 题库")
@RestController
@RequestMapping("/problemset")
public class AppProblemsetController {

    @Autowired
    private ProblemsetService problemsetService;
    @Autowired
    private QuestionService questionService;

    @ApiOperation(value = "获取所有题库信息")
    @GetMapping("/getAll")
    private CommonResult<List<ProblemsetListRespVO>> getProblemsetAll() {
        List<ProblemsetDO> problemsetDOs = problemsetService.selectProblemsetAll();
        List<ProblemsetListRespVO> problemsetListRespVOList = problemsetDOs.stream().map(item -> {
            ProblemsetListRespVO problemsetListRespVO = new ProblemsetListRespVO();
            BeanUtils.copyProperties(item, problemsetListRespVO);
            return problemsetListRespVO;
        }).collect(Collectors.toList());
        return CommonResult.success(problemsetListRespVOList);
    }

    @ApiOperation(value = "获取相关题目分页列表")
    @GetMapping("/page")
    public CommonResult<CommonPage<AppProblemsetQuestionQueryRespVO>> getProblemsetQuestionPage(AppProblemsetQuestionQueryReqVO questionQueryReqVO) {
        CommonPage<QuestionDO> questionQueryReqVOCommonPage = questionService.selectAppProblemsetQuestionList(questionQueryReqVO);
        // 构造返回结果
        List<AppProblemsetQuestionQueryRespVO> appProblemsetQuestionQueryRespVOList = questionQueryReqVOCommonPage.getList().stream().map(item -> {
            AppProblemsetQuestionQueryRespVO appProblemsetQuestionQueryRespVO = new AppProblemsetQuestionQueryRespVO();
            BeanUtils.copyProperties(item, appProblemsetQuestionQueryRespVO);
            return appProblemsetQuestionQueryRespVO;
        }).collect(Collectors.toList());
        CommonPage<AppProblemsetQuestionQueryRespVO> appQuestionQueryRespVOCommonPage = new CommonPage<>(questionQueryReqVOCommonPage.getTotal(), appProblemsetQuestionQueryRespVOList);
        return CommonResult.success(appQuestionQueryRespVOCommonPage);
    }
}
