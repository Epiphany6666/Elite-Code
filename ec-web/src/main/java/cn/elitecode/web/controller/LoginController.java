package cn.elitecode.web.controller;

import cn.elitecode.common.api.CommonResult;
import cn.elitecode.common.properties.JWTProperties;
import cn.elitecode.framework.core.utils.SecurityUtil;
import cn.elitecode.model.dto.user.UserLoginDTO;
import cn.elitecode.model.entity.User;
import cn.elitecode.model.vo.LoginUserVO;
import cn.elitecode.service.LoginService;
import cn.elitecode.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "LoginController", description = "用户登录")
@RestController
@RequestMapping("/admin-api/system/auth")
public class LoginController {

    @Autowired
    private LoginService loginService;
    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户登录")
    @PostMapping("/login")
    private CommonResult<LoginUserVO> login(@Validated @RequestBody UserLoginDTO userLoginDTO) {
        String tokenHead = JWTProperties.getTokenHead();
        String token = loginService.login(userLoginDTO.getUsername(), userLoginDTO.getPassword());
        LoginUserVO loginUserVO = new LoginUserVO(tokenHead, token);
        return CommonResult.success(loginUserVO);
    }

    @ApiOperation(value = "获取用户信息")
    @GetMapping("/getInfo")
    private CommonResult<User> getInfo() {
        User user = userService.selectUserById(SecurityUtil.getUserId());
        return CommonResult.success(user);
    }

}
