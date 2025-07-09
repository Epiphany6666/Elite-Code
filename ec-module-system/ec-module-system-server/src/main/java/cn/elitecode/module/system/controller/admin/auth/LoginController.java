package cn.elitecode.module.system.controller.admin.auth;

import cn.elitecode.framework.common.pojo.CommonResult;
import cn.elitecode.framework.security.config.JWTProperties;
import cn.elitecode.framework.security.core.LoginUserVO;
import cn.elitecode.framework.security.core.utils.SecurityUtil;
import cn.elitecode.module.system.controller.admin.auth.vo.UserLoginReqVO;
import cn.elitecode.module.system.dal.dataobject.user.UserDO;
import cn.elitecode.module.system.service.auth.LoginService;
import cn.elitecode.module.system.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "LoginController", description = "用户登录")
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;
    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户登录")
    @PostMapping("/login")
    private CommonResult<LoginUserVO> login(@Validated @RequestBody UserLoginReqVO userLoginReqVO) {
        String tokenHead = JWTProperties.getTokenHead();
        String token = loginService.login(userLoginReqVO.getUsername(), userLoginReqVO.getPassword());
        LoginUserVO loginUserVO = new LoginUserVO(tokenHead, token);
        return CommonResult.success(loginUserVO);
    }

    @ApiOperation(value = "获取用户信息")
    @GetMapping("/getInfo")
    private CommonResult<UserDO> getInfo() {
        UserDO userDO = userService.selectUserById(SecurityUtil.getUserId());
        return CommonResult.success(userDO);
    }

}
