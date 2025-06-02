package cn.elitecode.web.controller;

import cn.elitecode.common.api.CommonResult;
import cn.elitecode.common.utils.SecurityUtil;
import cn.elitecode.constant.HttpStatus;
import cn.elitecode.model.dto.user.UserRegisterDTO;
import cn.elitecode.model.entity.User;
import cn.elitecode.service.RegisterService;
import cn.elitecode.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "RegisterController", description = "用户注册")
@RestController
public class RegisterController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private RegisterService registerService;

    @ApiOperation(value = "用户注册")
    @PostMapping("/register")
    private CommonResult<Long> register(@Validated @RequestBody UserRegisterDTO userRegisterDTO) {
        // 校验
        String userPassword = userRegisterDTO.getPassword();
        String checkPassword = userRegisterDTO.getCheckPassword();

        if (!userPassword.equals(checkPassword)) {
            return CommonResult.error(HttpStatus.PARAMS_ERROR, "两次输入的密码不一致");
        }
        User user = new User();
        user.setUsername(userRegisterDTO.getUsername());
        if (!userService.checkUsernameUnique(user)) {
            return CommonResult.error(HttpStatus.PARAMS_ERROR, "用户注册 '" + user.getUsername() + "' 失败，账号已存在");
        }
        user.setPassword(SecurityUtil.encryptPassword(userPassword));
        Long registerUserId = registerService.register(user);
        return CommonResult.success(registerUserId);
    }

}
