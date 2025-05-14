package cn.elitecode.web.controller;

import cn.elitecode.common.api.CommonResult;
import cn.elitecode.model.dto.resourcecategory.ResourceCategoryAddDTO;
import cn.elitecode.model.dto.resourcecategory.ResourceCategoryUpdateDTO;
import cn.elitecode.model.entity.ResourceCategory;
import cn.elitecode.service.ResourceCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Api(tags = "ResourceCategoryController", description = "后台资源分类管理")
@RestController
@RequestMapping("/resourceCategory")
public class ResourceCategoryController {

    @Autowired
    private ResourceCategoryService resourceCategoryService;

    @ApiOperation(value = "新增后台资源分类")
    @PostMapping
    private CommonResult<Long> addResourceCategory(@Validated @RequestBody ResourceCategoryAddDTO resourceCategoryAddDTO) {
        Long resourceCategoryId = resourceCategoryService.addResourceCategory(resourceCategoryAddDTO);
        return CommonResult.success(resourceCategoryId);
    }

    @ApiOperation(value = "根据id修改后台资源分类")
    @PutMapping
    private CommonResult updateResourceCategory(@Validated @RequestBody ResourceCategoryUpdateDTO resourceCategoryUpdateDTO) {
        resourceCategoryService.updateResourceCategoryById(resourceCategoryUpdateDTO);
        return CommonResult.success();
    }

    @ApiOperation(value = "根据id数组批量删除后台资源分类")
    @DeleteMapping("/{resourceCategoryIds}")
    private CommonResult removeResourceCategory(@PathVariable Long[] resourceCategoryIds) {
        resourceCategoryService.removeByResourceCategoryIds(resourceCategoryIds);
        return CommonResult.success();
    }

    @ApiOperation(value = "查询所有后台资源分类")
    @GetMapping("/listAll")
    private CommonResult<List<ResourceCategory>> listResourceCategoryAll() {
        List<ResourceCategory> resourceCategoryList = resourceCategoryService.selectResourceCategoryAll();
        return CommonResult.success(resourceCategoryList);
    }
}
