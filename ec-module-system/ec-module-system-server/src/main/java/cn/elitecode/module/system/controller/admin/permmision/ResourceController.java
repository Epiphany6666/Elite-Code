package cn.elitecode.module.system.controller.admin.permmision;

import cn.elitecode.framework.common.pojo.CommonPage;
import cn.elitecode.framework.common.pojo.CommonResult;
import cn.elitecode.module.system.controller.admin.permmision.vo.resource.ResourceAddReqVO;
import cn.elitecode.module.system.controller.admin.permmision.vo.resource.ResourceQueryReqVO;
import cn.elitecode.module.system.controller.admin.permmision.vo.resource.ResourceUpdateReqVO;
import cn.elitecode.module.system.dal.dataobject.permission.ResourceDO;
import cn.elitecode.module.system.service.permmision.ResourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "ResourceController", description = "后台资源管理")
@RestController
@RequestMapping("/system/resource")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @ApiOperation(value = "根据分页条件查询后台资源")
    @PostMapping("/list")
    private CommonResult<CommonPage<ResourceDO>> listResourceByPage(@RequestBody ResourceQueryReqVO resourceQueryReqVO) {
        CommonPage<ResourceDO> resourcePage = resourceService.selectResourceListByPage(resourceQueryReqVO);
        return CommonResult.success(resourcePage);
    }

    @ApiOperation(value = "新增后台资源")
    @PostMapping
    private CommonResult<Long> addResource(@Validated @RequestBody ResourceAddReqVO resourceAddReqVO) {
        Long resourceId = resourceService.addResource(resourceAddReqVO);
        return CommonResult.success(resourceId);
    }

    @ApiOperation(value = "根据id修改后台资源")
    @PutMapping
    private CommonResult updateResource(@Validated @RequestBody ResourceUpdateReqVO resourceUpdateReqVO) {
        resourceService.updateResourceById(resourceUpdateReqVO);
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
    private CommonResult<ResourceDO> getResource(@PathVariable Long resourceId) {
        ResourceDO resourceDO = resourceService.getResourceById(resourceId);
        return CommonResult.success(resourceDO);
    }

    @ApiOperation(value = "查询所有后台资源")
    @GetMapping("/listAll")
    private CommonResult<List<ResourceDO>> listResourceAll() {
        List<ResourceDO> resourceDOList = resourceService.listResourceAll();
        return CommonResult.success(resourceDOList);
    }
}
