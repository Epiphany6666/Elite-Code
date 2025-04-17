package cn.elitecode.web.controller;

import cn.elitecode.common.BaseContext;
import cn.elitecode.common.api.CommonPage;
import cn.elitecode.common.api.CommonResult;
import cn.elitecode.common.utils.SecurityUtils;
import cn.elitecode.constant.HttpStatus;
import cn.elitecode.model.dto.user.UserAddDTO;
import cn.elitecode.model.dto.user.UserQueryDTO;
import cn.elitecode.model.dto.user.UserUpdateDTO;
import cn.elitecode.model.entity.User;
import cn.elitecode.service.UserService;
import cn.hutool.core.util.ArrayUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 用户控制器
 */
@Api(tags = "UserController", description = "用户管理")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "根据条件分页查询用户信息")
    @PostMapping("/list")
    private CommonResult<CommonPage<User>> listUser(@RequestBody UserQueryDTO userQueryDTO) {
        return userService.selectUserList(userQueryDTO);
    }

    @ApiOperation(value = "根据id查询用户信息")
    @GetMapping("/{userId}")
    private CommonResult<User> getUser(@PathVariable Long userId) {
        User user = userService.selectUserById(userId);
        return CommonResult.success(user);
    }

    @ApiOperation(value = "新增用户")
    @PostMapping
    private CommonResult<Long> addUser(@Validated @RequestBody UserAddDTO userAddDTO) {
        User user = new User();
        BeanUtils.copyProperties(userAddDTO, user);
        if (!userService.checkUsernameUnique(user)) {
            return CommonResult.error(HttpStatus.PARAMS_ERROR, "新增用户 '" + user.getUsername() + "' 失败，账号已存在");
        }
        user.setCreateBy(BaseContext.getCurrentId());
        user.setPassword(SecurityUtils.encryptPassword(userAddDTO.getPassword()));
        Long userId = userService.addUser(user);
        return CommonResult.success(userId);
    }

    @ApiOperation(value = "根据id更新用户信息")
    @PutMapping
    private CommonResult updateUser(@Validated @RequestBody UserUpdateDTO userUpdateDTO) {
        User user = new User();
        BeanUtils.copyProperties(userUpdateDTO, user);
        userService.updateUser(user);
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
