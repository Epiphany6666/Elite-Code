package cn.luoyan.elitecode.controller;

import cn.luoyan.elitecode.common.AjaxResult;
import cn.luoyan.elitecode.common.constant.HttpStatus;
import cn.luoyan.elitecode.model.dto.user.UserLoginDTO;
import cn.luoyan.elitecode.model.dto.user.UserRegisterDTO;
import cn.luoyan.elitecode.model.vo.LoginUserVO;
import cn.luoyan.elitecode.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户信息
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户登录
     * @param userLoginDTO
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping("/login")
    private AjaxResult<LoginUserVO> login(@RequestBody UserLoginDTO userLoginDTO, HttpServletRequest request) {
        if (userLoginDTO == null) {
            return AjaxResult.error(HttpStatus.PARAMS_ERROR, "登录参数错误");
        }
        String userAccount = userLoginDTO.getUserAccount();
        String userPassword = userLoginDTO.getUserPassword();

        // 校验
        if (StringUtils.isAnyBlank(userAccount, userPassword)) {
            return AjaxResult.error(HttpStatus.PARAMS_ERROR, "账号或密码为空");
        }
        if (userAccount.length() < 4) {
            return AjaxResult.error(HttpStatus.PARAMS_ERROR, "账号长度不足4位");
        }
        if (userPassword.length() < 8) {
            return AjaxResult.error(HttpStatus.PARAMS_ERROR, "密码长度不足8位");
        }

        return AjaxResult.success(userService.login(userAccount, userPassword, request));
    }

}
