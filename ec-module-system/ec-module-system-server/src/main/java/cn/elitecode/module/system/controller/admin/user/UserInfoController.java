package cn.elitecode.module.system.controller.admin.user;

import cn.elitecode.framework.common.pojo.CommonResult;
import cn.elitecode.module.system.controller.admin.user.vo.UserUpdateProfileDto;
import cn.elitecode.module.system.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "UserInfoController", description = "个人信息管理")
@RestController
@RequestMapping("/system/user/profile")
public class UserInfoController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "更新个人信息")
    @PutMapping
    private CommonResult updateProfile(@RequestBody UserUpdateProfileDto userUpdateProfileDto) {
        userService.updateUserProfile(userUpdateProfileDto);
        return CommonResult.success();
    }

}
