package cn.elitecode.module.system.controller.admin.auth;

import cn.elitecode.framework.common.enums.HttpStatus;
import cn.elitecode.framework.common.pojo.CommonResult;
import cn.elitecode.framework.security.core.utils.SecurityUtil;
import cn.elitecode.module.system.controller.admin.auth.vo.UserRegisterReqVO;
import cn.elitecode.module.system.dal.dataobject.user.UserDO;
import cn.elitecode.module.system.service.auth.RegisterService;
import cn.elitecode.module.system.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
    private CommonResult<Long> register(@Validated @RequestBody UserRegisterReqVO userRegisterReqVO) {
        // 校验
        String userPassword = userRegisterReqVO.getPassword();
        String checkPassword = userRegisterReqVO.getCheckPassword();

        if (!userPassword.equals(checkPassword)) {
            return CommonResult.error(HttpStatus.PARAMS_ERROR, "两次输入的密码不一致");
        }
        UserDO userDO = new UserDO();
        userDO.setUsername(userRegisterReqVO.getUsername());
        if (!userService.checkUsernameUnique(userDO)) {
            return CommonResult.error(HttpStatus.PARAMS_ERROR, "用户注册 '" + userDO.getUsername() + "' 失败，账号已存在");
        }
        userDO.setPassword(SecurityUtil.encryptPassword(userPassword));
        Long registerUserId = registerService.register(userDO);
        return CommonResult.success(registerUserId);
    }

}
