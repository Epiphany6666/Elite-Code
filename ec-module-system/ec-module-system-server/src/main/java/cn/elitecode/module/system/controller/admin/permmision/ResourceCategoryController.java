package cn.elitecode.module.system.controller.admin.permmision;

import cn.elitecode.framework.common.pojo.CommonResult;
import cn.elitecode.module.system.controller.admin.permmision.vo.resourcecategory.ResourceCategoryAddReqVO;
import cn.elitecode.module.system.controller.admin.permmision.vo.resourcecategory.ResourceCategoryUpdateReqVO;
import cn.elitecode.module.system.dal.dataobject.permission.ResourceCategory;
import cn.elitecode.module.system.service.permmision.ResourceCategoryService;
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
    private CommonResult<Long> addResourceCategory(@Validated @RequestBody ResourceCategoryAddReqVO resourceCategoryAddReqVO) {
        Long resourceCategoryId = resourceCategoryService.addResourceCategory(resourceCategoryAddReqVO);
        return CommonResult.success(resourceCategoryId);
    }

    @ApiOperation(value = "根据id修改后台资源分类")
    @PutMapping
    private CommonResult updateResourceCategory(@Validated @RequestBody ResourceCategoryUpdateReqVO resourceCategoryUpdateReqVO) {
        resourceCategoryService.updateResourceCategoryById(resourceCategoryUpdateReqVO);
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

    @ApiOperation(value = "根据id查询后台资源分类")
    @GetMapping("/{resourceCategoryId}")
    private CommonResult<ResourceCategory> getResourceCategory(@PathVariable Long resourceCategoryId) {
        ResourceCategory resourceCategory = resourceCategoryService.selectResourceCategoryById(resourceCategoryId);
        return CommonResult.success(resourceCategory);
    }
}
