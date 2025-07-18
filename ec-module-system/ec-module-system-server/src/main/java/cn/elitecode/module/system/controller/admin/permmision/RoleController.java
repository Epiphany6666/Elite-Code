package cn.elitecode.module.system.controller.admin.permmision;

import cn.elitecode.framework.common.pojo.CommonPage;
import cn.elitecode.framework.common.pojo.CommonResult;
import cn.elitecode.module.system.controller.admin.permmision.vo.role.RoleAddReqVO;
import cn.elitecode.module.system.controller.admin.permmision.vo.role.RoleQueryReqVO;
import cn.elitecode.module.system.controller.admin.permmision.vo.role.RoleUpdateReqVO;
import cn.elitecode.module.system.dal.dataobject.permission.ResourceDO;
import cn.elitecode.module.system.dal.dataobject.permission.RoleDO;
import cn.elitecode.module.system.service.permmision.ResourceService;
import cn.elitecode.module.system.service.permmision.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "RoleController", description = "角色管理")
@RestController
@RequestMapping("/system/role")
public class RoleController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private ResourceService resourceService;

    @ApiOperation(value = "根据分页条件查询角色信息")
    @PostMapping("/list")
    private CommonResult<CommonPage<RoleDO>> listRole(@RequestBody RoleQueryReqVO roleQueryReqVO) {
        CommonPage<RoleDO> page = roleService.selectRoleListByPage(roleQueryReqVO);
        return CommonResult.success(page);
    }

    @ApiOperation(value = "新增角色")
    @PostMapping
    private CommonResult<Long> addRole(@Validated @RequestBody RoleAddReqVO roleAddReqVO) {
        Long roleId = roleService.addRole(roleAddReqVO);
        return CommonResult.success(roleId);
    }

    @ApiOperation(value = "根据id修改角色信息")
    @PutMapping
    private CommonResult updateRole(@Validated @RequestBody RoleUpdateReqVO roleUpdateReqVO) {
        roleService.updateRole(roleUpdateReqVO);
        return CommonResult.success();
    }

    @ApiOperation(value = "根据id数组批量删除角色信息")
    @DeleteMapping("/{roleIds}")
    private CommonResult removeRoles(@PathVariable("roleIds") Long[] roleIds) {
        roleService.removeRoleByIds(roleIds);
        return CommonResult.success();
    }

    @ApiOperation(value = "根据id查询角色信息")
    @GetMapping("/{roleId}")
    private CommonResult<RoleDO> getRole(@PathVariable Long roleId) {
        RoleDO roleDO = roleService.selectRoleById(roleId);
        return CommonResult.success(roleDO);
    }

    @ApiOperation(value = "获取角色相关后台资源")
    @GetMapping("/listResource/{roleId}")
    private CommonResult<List<ResourceDO>> listResourceByRoleId(@PathVariable Long roleId) {
        List<ResourceDO> resourceDOList = roleService.listResourceByRoleId(roleId);
        return CommonResult.success(resourceDOList);
    }

    @ApiOperation(value = "给角色分配后台资源")
    @PostMapping("/allocateResource")
    private CommonResult allocateResource(Long roleId, Long[] resourceIds) {
        resourceService.allocateResource(roleId, resourceIds);
        return CommonResult.success();
    }
}
