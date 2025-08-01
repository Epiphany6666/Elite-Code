package cn.elitecode.module.member.controller.app.auth;

import cn.elitecode.framework.common.enums.HttpStatus;
import cn.elitecode.framework.common.pojo.CommonResult;
import cn.elitecode.framework.security.config.JWTProperties;
import cn.elitecode.module.member.controller.app.auth.vo.AppAuthLoginReqVO;
import cn.elitecode.module.member.controller.app.auth.vo.AppAuthLoginRespVO;
import cn.elitecode.module.member.controller.app.auth.vo.AppAuthRegisterReqVO;
import cn.elitecode.module.member.service.auth.MemberAuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "AppAuthController", description = "用户 APP - 认证")
@RestController
@RequestMapping("/member/auth")
public class AppAuthController {

    @Autowired
    MemberAuthService memberAuthService;

    @ApiOperation(value = "使用手机号 + 密码登录")
    @PostMapping("/login")
    private CommonResult<AppAuthLoginRespVO> login(@RequestBody @Validated AppAuthLoginReqVO reqVO) {
        String tokenHead = JWTProperties.getTokenHead();
        String token = memberAuthService.login(reqVO.getMobile(), reqVO.getPassword());
        AppAuthLoginRespVO appAuthLoginRespVO = new AppAuthLoginRespVO(tokenHead, token);
        return CommonResult.success(appAuthLoginRespVO);
    }

    @ApiOperation(value = "注册")
    @PostMapping("/register")
    private CommonResult<Long> register(@RequestBody @Validated AppAuthRegisterReqVO registerReqVO) {
        String phone = registerReqVO.getPhone();
        String password = registerReqVO.getPassword();
        String checkPassword = registerReqVO.getCheckPassword();

        if (!password.equals(checkPassword)) {
            return CommonResult.error(HttpStatus.PARAMS_ERROR, "两次输入的密码不一致");
        }
        Long userId = memberAuthService.register(phone, password);
        return CommonResult.success(userId);
    }
}
