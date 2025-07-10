package cn.elitecode.module.system.controller.admin.user;

import cn.elitecode.framework.common.enums.HttpStatus;
import cn.elitecode.framework.common.pojo.CommonPage;
import cn.elitecode.framework.common.pojo.CommonResult;
import cn.elitecode.framework.security.core.utils.SecurityUtil;
import cn.elitecode.module.system.controller.admin.user.vo.UserAddReqVO;
import cn.elitecode.module.system.controller.admin.user.vo.UserQueryReqVO;
import cn.elitecode.module.system.controller.admin.user.vo.UserUpdateReqVO;
import cn.elitecode.module.system.dal.dataobject.permission.RoleDO;
import cn.elitecode.module.system.dal.dataobject.user.UserDO;
import cn.elitecode.module.system.service.permmision.RoleService;
import cn.elitecode.module.system.service.user.UserService;
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
    private CommonResult<CommonPage<UserDO>> listUser(@RequestBody UserQueryReqVO userQueryReqVO) {
        CommonPage<UserDO> page = userService.selectUserList(userQueryReqVO);
        return CommonResult.success(page);
    }

    @ApiOperation(value = "根据id查询用户信息")
    @GetMapping("/{userId}")
    private CommonResult<Map<String, Object>> getUser(@PathVariable Long userId) {
        Map<String, Object> result = new HashMap<>();
        UserDO userDO = userService.selectUserById(userId);
        result.put("user", userDO);
        List<Long> roleIds = userDO.getRoleList().stream().map(RoleDO::getId).toList();
        result.put("roleIds", roleIds);
        List<RoleDO> roleDOAll = roleService.selectRoleListAll();
        result.put("roleAll", roleDOAll);
        return CommonResult.success(result);
    }

    @ApiOperation(value = "新增用户")
    @PostMapping
    private CommonResult<Long> addUser(@Validated @RequestBody UserAddReqVO userAddReqVO) {
        Long userId = userService.addUser(userAddReqVO);
        return CommonResult.success(userId);
    }

    @ApiOperation(value = "根据id更新用户信息")
    @PutMapping
    private CommonResult updateUser(@Validated @RequestBody UserUpdateReqVO userUpdateReqVO) {
        userService.updateUser(userUpdateReqVO);
        return CommonResult.success();
    }

    @ApiOperation(value = "批量删除用户")
    @DeleteMapping("/{userIds}")
    private CommonResult removeUsers(@ApiParam("需要删除的id数组") @PathVariable Long[] userIds) {
        Long id = SecurityUtil.getUserId();
        if (ArrayUtil.contains(userIds, id)) {
            return CommonResult.error(HttpStatus.PARAMS_ERROR, "不能删除当前用户");
        }
        userService.removeByUserIds(userIds);
        return CommonResult.success();
    }

}
