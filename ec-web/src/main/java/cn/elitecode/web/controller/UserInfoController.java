package cn.elitecode.web.controller;

import cn.elitecode.common.api.CommonResult;
import cn.elitecode.model.dto.user.UserUpdateDTO;
import cn.elitecode.model.dto.user.UserUpdateProfileDto;
import cn.elitecode.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "UserInfoController", description = "个人信息管理")
@RestController("/user/profile")
public class UserInfoController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "更新个人信息")
    @PutMapping
    private CommonResult updateProfile(@RequestBody UserUpdateProfileDto userUpdateProfileDto) {
        UserUpdateDTO userUpdateDTO = new UserUpdateDTO();
        BeanUtils.copyProperties(userUpdateProfileDto, userUpdateDTO);
        userService.updateUser(userUpdateDTO);
        return CommonResult.success();
    }

}
