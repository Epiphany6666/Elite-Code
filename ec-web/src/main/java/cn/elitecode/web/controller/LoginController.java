package cn.elitecode.web.controller;

import cn.elitecode.common.api.CommonResult;
import cn.elitecode.common.properties.JWTProperties;
import cn.elitecode.common.utils.SecurityUtils;
import cn.elitecode.model.bo.LoginUser;
import cn.elitecode.model.dto.user.UserLoginDTO;
import cn.elitecode.model.entity.User;
import cn.elitecode.model.vo.LoginUserVO;
import cn.elitecode.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "LoginController", description = "用户注册")
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @ApiOperation(value = "用户登录")
    @PostMapping("/login")
    private CommonResult<LoginUserVO> login(@RequestBody @Validated UserLoginDTO userLoginDTO) {
        String username = userLoginDTO.getUsername();
        String userPassword = userLoginDTO.getPassword();
        String tokenHead = JWTProperties.getTokenHead();
        String token = loginService.login(username, userPassword);
        LoginUserVO loginUserVO = new LoginUserVO(tokenHead, token);
        return CommonResult.success(loginUserVO);
    }

    @ApiOperation(value = "获取用户信息")
    @GetMapping("/getInfo")
    private CommonResult<User> getInfo() {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        User user = loginUser.getUser();
        return CommonResult.success(user);
    }

}
