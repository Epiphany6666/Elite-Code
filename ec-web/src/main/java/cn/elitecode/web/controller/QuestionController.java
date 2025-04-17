package cn.elitecode.web.controller;

import cn.elitecode.common.api.CommonPage;
import cn.elitecode.common.api.CommonResult;
import cn.elitecode.model.dto.question.QuestionAddDTO;
import cn.elitecode.model.dto.question.QuestionQueryDTO;
import cn.elitecode.model.dto.question.QuestionUpdateDTO;
import cn.elitecode.model.entity.Problemset;
import cn.elitecode.model.entity.Question;
import cn.elitecode.model.entity.Tag;
import cn.elitecode.service.ProblemsetService;
import cn.elitecode.service.QuestionService;
import cn.elitecode.service.TagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;

@Api(tags = "QuestionController", description = "题目管理")
@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;
    @Autowired
    private ProblemsetService problemsetService;
    @Autowired
    private TagService tagService;

    @ApiOperation(value = "根据分页条件查询题目信息")
    @PostMapping("/list")
    private CommonPage<Question> listQuestion(@RequestBody QuestionQueryDTO questionQueryDTO) {
        return questionService.selectQuestionList(questionQueryDTO);
    }

    @ApiOperation(value = "新增题目")
    @PostMapping
    private CommonResult<Long> addQuestion(@Validated @RequestBody QuestionAddDTO questionAddDTO) {
        Long questionId = questionService.addQuestion(questionAddDTO);
        return CommonResult.success(questionId);
    }

    @ApiOperation(value = "根据id查询题目信息")
    @GetMapping("/{questionId}")
    private CommonResult<HashMap> getQuestion(@PathVariable Long questionId) {
        HashMap<String, Object> result = new HashMap<>();
        Question question = questionService.selectQuestionById(questionId);
        result.put("question", question);
        List<Long> problemsetIds = question.getProblemsetList().stream().map(Problemset::getId).toList();
        List<Problemset> problemsetAll = problemsetService.selectProblemsetAll();
        result.put("problemsetIds", problemsetIds);
        result.put("problemsetAll", problemsetAll);
        List<Long> tagIds = question.getTagList().stream().map(Tag::getId).toList();
        List<Tag> tagAll = tagService.selectTagAll();
        result.put("tagIds", tagIds);
        result.put("tagAll", tagAll);
        return CommonResult.success(result);
    }

    @ApiOperation(value = "根据id更新题目信息")
    @PutMapping
    private CommonResult updateQuestion(@Validated @RequestBody QuestionUpdateDTO questionUpdateDTO) {
        questionService.updateQuestion(questionUpdateDTO);
        return CommonResult.success();
    }

    @ApiOperation(value = "批量删除题目")
    @DeleteMapping("/{questionIds}")
    private CommonResult removeQuestions(@ApiParam("需要删除的id数组") @PathVariable Long[] questionIds) {
        questionService.removeByQuestionIds(questionIds);
        return CommonResult.success();
    }

}
