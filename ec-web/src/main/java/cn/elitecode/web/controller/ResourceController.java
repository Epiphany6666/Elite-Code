package cn.elitecode.web.controller;

import cn.elitecode.common.api.CommonPage;
import cn.elitecode.common.api.CommonResult;
import cn.elitecode.model.dto.resource.ResourceAddDTO;
import cn.elitecode.model.dto.resource.ResourceQueryDTO;
import cn.elitecode.model.dto.resource.ResourceUpdateDTO;
import cn.elitecode.model.entity.Resource;
import cn.elitecode.service.ResourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Api(tags = "ResourceController", description = "后台资源管理")
@RestController
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @ApiOperation(value = "根据分页条件查询后台资源")
    @PostMapping("/list")
    private CommonResult<CommonPage<Resource>> listResourceByPage(@RequestBody ResourceQueryDTO resourceQueryDTO) {
        CommonPage<Resource> resourcePage = resourceService.selectResourceListByPage(resourceQueryDTO);
        return CommonResult.success(resourcePage);
    }

    @ApiOperation(value = "新增后台资源")
    @PostMapping
    private CommonResult<Long> addResource(@Validated @RequestBody ResourceAddDTO resourceAddDTO) {
        Long resourceId = resourceService.addResource(resourceAddDTO);
        return CommonResult.success(resourceId);
    }

    @ApiOperation(value = "根据id修改后台资源")
    @PutMapping
    private CommonResult updateResource(@Validated @RequestBody ResourceUpdateDTO resourceUpdateDTO) {
        resourceService.updateResourceById(resourceUpdateDTO);
        return CommonResult.success();
    }

    @ApiOperation(value = "根据id数组批量删除后台资源")
    @DeleteMapping("/{resourceIds}")
    private CommonResult removeResources(@PathVariable Long[] resourceIds) {
        resourceService.removeByResourceIds(resourceIds);
        return CommonResult.success();
    }

    @ApiOperation(value = "根据id查询后台资源")
    @GetMapping("/{resourceId}")
    private CommonResult<Resource> getResource(@PathVariable Long resourceId) {
        Resource resource = resourceService.getResourceById(resourceId);
        return CommonResult.success(resource);
    }

    @ApiOperation(value = "查询所有后台资源")
    @GetMapping("/listAll")
    private CommonResult<List<Resource>> listResourceAll() {
        List<Resource> resourceList = resourceService.listResourceAll();
        return CommonResult.success(resourceList);
    }
}
