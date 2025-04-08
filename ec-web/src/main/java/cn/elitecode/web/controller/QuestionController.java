package cn.elitecode.web.controller;

import cn.elitecode.common.api.CommonPage;
import cn.elitecode.common.api.CommonResult;
import cn.elitecode.common.utils.SecurityUtils;
import cn.elitecode.model.dto.question.QuestionAddDTO;
import cn.elitecode.model.dto.question.QuestionQueryDTO;
import cn.elitecode.model.dto.question.QuestionUpdateDTO;
import cn.elitecode.model.entity.Question;
import cn.elitecode.service.QuestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "QuestionController", description = "题目管理")
@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @ApiOperation(value = "根据分页条件查询题目信息")
    @PostMapping("/list")
    private CommonPage<Question> listQuestion(@RequestBody QuestionQueryDTO questionQueryDTO) {
        return questionService.selectQuestionList(questionQueryDTO);
    }

    @ApiOperation(value = "新增题目")
    @PostMapping
    private CommonResult<Long> addQuestion(@RequestBody @Validated QuestionAddDTO questionAddDTO) {
        Question question = new Question();
        BeanUtils.copyProperties(questionAddDTO, question);
        question.setCreateBy(SecurityUtils.getUserId());
        Long questionId = questionService.addQuestion(question);
        return CommonResult.success(questionId);
    }

    @ApiOperation(value = "根据id查询题目信息")
    @GetMapping("/{questionId}")
    private CommonResult<Question> getQuestion(@PathVariable Long questionId) {
        Question question = questionService.selectQuestionById(questionId);
        return CommonResult.success(question);
    }

    @ApiOperation(value = "根据id更新题目信息")
    @PutMapping
    private CommonResult updateQuestion(@RequestBody @Validated QuestionUpdateDTO questionUpdateDTO) {
        Question question = new Question();
        BeanUtils.copyProperties(questionUpdateDTO, question);
        questionService.updateQuestion(question);
        return CommonResult.success();
    }

    @ApiOperation(value = "批量删除题目")
    @DeleteMapping("/{questionIds}")
    private CommonResult removeQuestions(@ApiParam("需要删除的id数组") @PathVariable Long[] questionIds) {
        questionService.removeByQuestionIds(questionIds);
        return CommonResult.success();
    }

}
