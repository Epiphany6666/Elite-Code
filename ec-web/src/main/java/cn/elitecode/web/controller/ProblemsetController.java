package cn.elitecode.web.controller;

import cn.elitecode.common.api.CommonPage;
import cn.elitecode.common.api.CommonResult;
import cn.elitecode.common.utils.SecurityUtils;
import cn.elitecode.model.dto.problemset.ProblemsetAddDTO;
import cn.elitecode.model.dto.problemset.ProblemsetQueryDTO;
import cn.elitecode.model.dto.problemset.ProblemsetQueryQuestionDTO;
import cn.elitecode.model.dto.problemset.ProblemsetUpdateDTO;
import cn.elitecode.model.entity.Problemset;
import cn.elitecode.model.entity.Question;
import cn.elitecode.service.ProblemsetService;
import cn.elitecode.service.QuestionService;
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
    private CommonResult<CommonPage<Problemset>> listProblemset(@RequestBody ProblemsetQueryDTO problemsetQueryDTO) {
        CommonPage<Problemset> pageResult = problemsetService.selectProblemsetList(problemsetQueryDTO);
        return CommonResult.success(pageResult);
    }

    @ApiOperation(value = "根据id查询题库信息")
    @GetMapping("/{problemsetId}")
    private CommonResult<Problemset> getProblemset(@PathVariable Long problemsetId) {
        Problemset problemset = problemsetService.selectProblemsetId(problemsetId);
        return CommonResult.success(problemset);
    }

    @ApiOperation(value = "新增题库")
    @PostMapping
    private CommonResult<Long> addProblemset(@Validated @RequestBody ProblemsetAddDTO problemsetAddDTO) {
        Problemset problemset = new Problemset();
        BeanUtils.copyProperties(problemsetAddDTO, problemset);
        problemset.setCreateBy(SecurityUtils.getUserId());
        Long problemsetId = problemsetService.addProblemset(problemset);
        return CommonResult.success(problemsetId);
    }

    @ApiOperation(value = "根据id修改题库信息")
    @PutMapping
    private CommonResult updateProblemset(@Validated @RequestBody ProblemsetUpdateDTO problemsetUpdateDTO) {
        Problemset problemset = new Problemset();
        BeanUtils.copyProperties(problemsetUpdateDTO, problemset);
        problemset.setUpdateBy(SecurityUtils.getUserId());
        problemsetService.updateProblemset(problemset);
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
    private CommonResult<CommonPage<Question>> getQuestionList(@RequestBody ProblemsetQueryQuestionDTO problemsetQueryQuestionDTO) {
        CommonPage<Question> pageResult = questionService.selectProblemsetQuestionList(problemsetQueryQuestionDTO);
        return CommonResult.success(pageResult);
    }

}
