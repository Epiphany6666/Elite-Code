package cn.elitecode.web.controller;

import cn.elitecode.common.BaseContext;
import cn.elitecode.common.api.CommonPage;
import cn.elitecode.common.api.CommonResult;
import cn.elitecode.constant.HttpStatus;
import cn.elitecode.model.dto.user.UserAddDTO;
import cn.elitecode.model.dto.user.UserQueryDTO;
import cn.elitecode.model.dto.user.UserUpdateDTO;
import cn.elitecode.model.entity.Role;
import cn.elitecode.model.entity.User;
import cn.elitecode.service.RoleService;
import cn.elitecode.service.UserService;
import cn.hutool.core.util.ArrayUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户控制器
 */
@Api(tags = "UserController", description = "用户管理")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @ApiOperation(value = "根据条件分页查询用户信息")
    @PostMapping("/list")
    private CommonResult<CommonPage<User>> listUser(@RequestBody UserQueryDTO userQueryDTO) {
        CommonPage<User> page = userService.selectUserList(userQueryDTO);
        return CommonResult.success(page);
    }

    @ApiOperation(value = "根据id查询用户信息")
    @GetMapping("/{userId}")
    private CommonResult<Map<String, Object>> getUser(@PathVariable Long userId) {
        Map<String, Object> result = new HashMap<>();
        User user = userService.selectUserById(userId);
        result.put("user", user);
        List<Long> roleIds = user.getRoleList().stream().map(Role::getId).toList();
        result.put("roleIds", roleIds);
        List<Role> roleAll = roleService.selectRoleListAll();
        result.put("roleAll", roleAll);
        return CommonResult.success(result);
    }

    @ApiOperation(value = "新增用户")
    @PostMapping
    private CommonResult<Long> addUser(@Validated @RequestBody UserAddDTO userAddDTO) {
        Long userId = userService.addUser(userAddDTO);
        return CommonResult.success(userId);
    }

    @ApiOperation(value = "根据id更新用户信息")
    @PutMapping
    private CommonResult updateUser(@Validated @RequestBody UserUpdateDTO userUpdateDTO) {
        userService.updateUser(userUpdateDTO);
        return CommonResult.success();
    }

    @ApiOperation(value = "批量删除用户")
    @DeleteMapping("/{userIds}")
    private CommonResult removeUsers(@ApiParam("需要删除的id数组") @PathVariable Long[] userIds) {
        Long id = BaseContext.getCurrentId();
        if (ArrayUtil.contains(userIds, id)) {
            return CommonResult.error(HttpStatus.PARAMS_ERROR, "不能删除当前用户");
        }
        userService.removeByUserIds(userIds);
        return CommonResult.success();
    }

}
