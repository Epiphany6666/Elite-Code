package cn.elitecode.module.resume.controller.app.question;

import cn.elitecode.framework.common.pojo.CommonResult;
import cn.elitecode.module.resume.controller.app.question.vo.AppQuestionRespVO;
import cn.elitecode.module.resume.dal.dataobject.question.QuestionDO;
import cn.elitecode.module.resume.service.question.QuestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "AppQuestionController", description = "用户 APP - 题目")
@RestController
@RequestMapping("/question")
public class AppQuestionController {

    @Autowired
    private QuestionService questionService;

    @ApiOperation(value = "根据id查询题目信息")
    @GetMapping("/get")
    private CommonResult<AppQuestionRespVO> getQuestion(@RequestParam("id") Long id) {
        QuestionDO questionDO = questionService.selectQuestionById(id);
        AppQuestionRespVO appQuestionRespVO = new AppQuestionRespVO();
        BeanUtils.copyProperties(questionDO, appQuestionRespVO);
        return CommonResult.success(appQuestionRespVO);
    }

}
