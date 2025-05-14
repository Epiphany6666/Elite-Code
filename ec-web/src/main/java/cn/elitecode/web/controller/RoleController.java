package cn.elitecode.web.controller;

import cn.elitecode.common.api.CommonPage;
import cn.elitecode.common.api.CommonResult;
import cn.elitecode.model.dto.role.RoleAddDTO;
import cn.elitecode.model.dto.role.RoleQueryDTO;
import cn.elitecode.model.dto.role.RoleUpdateDTO;
import cn.elitecode.model.entity.Resource;
import cn.elitecode.model.entity.Role;
import cn.elitecode.service.ResourceService;
import cn.elitecode.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Api(tags = "RoleController", description = "角色管理")
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private ResourceService resourceService;

    @ApiOperation(value = "根据分页条件查询角色信息")
    @PostMapping("/list")
    private CommonResult<CommonPage<Role>> listRole(@RequestBody RoleQueryDTO roleQueryDTO) {
        CommonPage<Role> page = roleService.selectRoleListByPage(roleQueryDTO);
        return CommonResult.success(page);
    }

    @ApiOperation(value = "新增角色")
    @PostMapping
    private CommonResult<Long> addRole(@Validated @RequestBody RoleAddDTO roleAddDTO) {
        Long roleId = roleService.addRole(roleAddDTO);
        return CommonResult.success(roleId);
    }

    @ApiOperation(value = "根据id修改角色信息")
    @PutMapping
    private CommonResult updateRole(@Validated @RequestBody RoleUpdateDTO roleUpdateDTO) {
        roleService.updateRole(roleUpdateDTO);
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
    private CommonResult<Role> getRole(@PathVariable Long roleId) {
        Role role = roleService.selectRoleById(roleId);
        return CommonResult.success(role);
    }

    @ApiOperation(value = "获取角色相关后台资源")
    @GetMapping("/listResource/{roleId}")
    private CommonResult<List<Resource>> listResourceByRoleId(@PathVariable Long roleId) {
        List<Resource> resourceList = roleService.listResourceByRoleId(roleId);
        return CommonResult.success(resourceList);
    }

    @ApiOperation(value = "给角色分配后台资源")
    @PostMapping("/allocateResource")
    private CommonResult allocateResource(Long roleId, Long[] resourceIds) {
        resourceService.allocateResource(roleId, resourceIds);
        return CommonResult.success();
    }
}
