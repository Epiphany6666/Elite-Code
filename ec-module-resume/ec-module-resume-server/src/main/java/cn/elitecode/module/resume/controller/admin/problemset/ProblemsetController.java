package cn.elitecode.module.resume.controller.admin.problemset;

import cn.elitecode.framework.common.pojo.CommonPage;
import cn.elitecode.framework.common.pojo.CommonResult;
import cn.elitecode.framework.security.core.utils.SecurityUtil;
import cn.elitecode.module.resume.controller.admin.problemset.vo.ProblemsetAddReqVO;
import cn.elitecode.module.resume.controller.admin.problemset.vo.ProblemsetQueryQuestionReqVO;
import cn.elitecode.module.resume.controller.admin.problemset.vo.ProblemsetQueryReqVO;
import cn.elitecode.module.resume.controller.admin.problemset.vo.ProblemsetUpdateReqVO;
import cn.elitecode.module.resume.dal.dataobject.problemset.ProblemsetDO;
import cn.elitecode.module.resume.dal.dataobject.question.QuestionDO;
import cn.elitecode.module.resume.service.problemset.ProblemsetService;
import cn.elitecode.module.resume.service.question.QuestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "ProblemsetController", description = "题库管理")
@RestController
@RequestMapping("/problemset")
public class ProblemsetController {

    @Autowired
    private ProblemsetService problemsetService;

    @Autowired
    private QuestionService questionService;

    @ApiOperation(value = "根据分页条件查询题库信息")
    @PostMapping("/list")
    private CommonResult<CommonPage<ProblemsetDO>> listProblemset(@RequestBody ProblemsetQueryReqVO problemsetQueryReqVO) {
        CommonPage<ProblemsetDO> pageResult = problemsetService.selectProblemsetList(problemsetQueryReqVO);
        return CommonResult.success(pageResult);
    }

    @ApiOperation(value = "根据id查询题库信息")
    @GetMapping("/{problemsetId}")
    private CommonResult<ProblemsetDO> getProblemset(@PathVariable Long problemsetId) {
        ProblemsetDO problemsetDO = problemsetService.selectProblemsetId(problemsetId);
        return CommonResult.success(problemsetDO);
    }

    @ApiOperation(value = "新增题库")
    @PostMapping
    private CommonResult<Long> addProblemset(@Validated @RequestBody ProblemsetAddReqVO problemsetAddReqVO) {
        ProblemsetDO problemsetDO = new ProblemsetDO();
        BeanUtils.copyProperties(problemsetAddReqVO, problemsetDO);
        problemsetDO.setCreateBy(SecurityUtil.getUserId());
        Long problemsetId = problemsetService.addProblemset(problemsetDO);
        return CommonResult.success(problemsetId);
    }

    @ApiOperation(value = "根据id修改题库信息")
    @PutMapping
    private CommonResult updateProblemset(@Validated @RequestBody ProblemsetUpdateReqVO problemsetUpdateReqVO) {
        ProblemsetDO problemsetDO = new ProblemsetDO();
        BeanUtils.copyProperties(problemsetUpdateReqVO, problemsetDO);
        problemsetDO.setUpdateBy(SecurityUtil.getUserId());
        problemsetService.updateProblemset(problemsetDO);
        return CommonResult.success();
    }

    @ApiOperation(value = "批量删除题库")
    @DeleteMapping("/{problemsetIds}")
    private CommonResult removeProblemsets(@ApiParam("需要删除的id数组") @PathVariable Long[] problemsetIds) {
        problemsetService.removeByProblemsetIds(problemsetIds);
        return CommonResult.success();
    }

    @ApiOperation(value = "根据分页条件查询所属题库的题目")
    @PostMapping("/questionList")
    private CommonResult<CommonPage<QuestionDO>> getQuestionList(@RequestBody ProblemsetQueryQuestionReqVO problemsetQueryQuestionReqVO) {
        CommonPage<QuestionDO> pageResult = questionService.selectProblemsetQuestionList(problemsetQueryQuestionReqVO);
        return CommonResult.success(pageResult);
    }

}
