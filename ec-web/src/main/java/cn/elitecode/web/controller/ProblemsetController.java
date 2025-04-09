package cn.elitecode.web.controller;

import cn.elitecode.common.api.CommonPage;
import cn.elitecode.common.api.CommonResult;
import cn.elitecode.common.utils.SecurityUtils;
import cn.elitecode.model.dto.problemset.ProblemsetAddDTO;
import cn.elitecode.model.dto.problemset.ProblemsetQueryDTO;
import cn.elitecode.model.dto.problemset.ProblemsetUpdateDTO;
import cn.elitecode.model.entity.Problemset;
import cn.elitecode.service.ProblemsetService;
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

    @ApiOperation(value = "根据分页条件查询题库信息")
    @PostMapping("/list")
    private CommonPage<Problemset> listProblemset(@RequestBody ProblemsetQueryDTO problemsetQueryDTO) {
        return problemsetService.selectProblemsetList(problemsetQueryDTO);
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

}
