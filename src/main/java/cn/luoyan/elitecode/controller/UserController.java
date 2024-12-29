package cn.luoyan.elitecode.controller;

import cn.luoyan.elitecode.common.CommonResult;
import cn.luoyan.elitecode.common.PageResult;
import cn.luoyan.elitecode.common.constant.HttpStatus;
import cn.luoyan.elitecode.model.dto.user.UserLoginDTO;
import cn.luoyan.elitecode.model.dto.user.UserQueryDTO;
import cn.luoyan.elitecode.model.dto.user.UserRegisterDTO;
import cn.luoyan.elitecode.model.dto.user.UserUpdateDTO;
import cn.luoyan.elitecode.model.vo.LoginUserVO;
import cn.luoyan.elitecode.model.vo.UserVO;
import cn.luoyan.elitecode.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

/**
 * 用户控制器
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
    private CommonResult<LoginUserVO> login(@RequestBody UserLoginDTO userLoginDTO, HttpServletRequest request) {
        if (userLoginDTO == null) {
            return CommonResult.error(HttpStatus.PARAMS_ERROR, "登录参数错误");
        }
        String userAccount = userLoginDTO.getUserAccount();
        String userPassword = userLoginDTO.getUserPassword();

        // 校验
        if (StringUtils.isAnyBlank(userAccount, userPassword)) {
            return CommonResult.error(HttpStatus.PARAMS_ERROR, "账号或密码为空");
        }
        if (userAccount.length() < 4) {
            return CommonResult.error(HttpStatus.PARAMS_ERROR, "账号长度不足4位");
        }
        if (userPassword.length() < 8) {
            return CommonResult.error(HttpStatus.PARAMS_ERROR, "密码长度不足8位");
        }

        return CommonResult.success(userService.login(userAccount, userPassword, request));
    }

    /**
     * 用户注册
     * @param userRegisterDTO
     * @return
     */
    @PostMapping("/register")
    private CommonResult<Long> register(@RequestBody UserRegisterDTO userRegisterDTO) {
        if (userRegisterDTO == null) {
            CommonResult.error(HttpStatus.PARAMS_ERROR, "注册参数错误");
        }
        String userAccount = userRegisterDTO.getUserAccount();
        String userPassword = userRegisterDTO.getUserPassword();
        String checkPassword = userRegisterDTO.getCheckPassword();
        if (StringUtils.isAnyBlank(userAccount, userPassword, checkPassword)) {
            return CommonResult.error(HttpStatus.PARAMS_ERROR, "账号或密码或校验密码为空");
        }
        if (userAccount.length() < 4) {
            return CommonResult.error(HttpStatus.PARAMS_ERROR, "账号长度不足4位");
        }
        if (userPassword.length() < 8) {
            return CommonResult.error(HttpStatus.PARAMS_ERROR, "密码长度不足8位");
        }
        if (!userPassword.equals(checkPassword)) {
            return CommonResult.error(HttpStatus.PARAMS_ERROR, "两次输入的密码不一致");
        }
        Long registerUserId = userService.register(userAccount, userPassword);
        return CommonResult.success(registerUserId);
    }

    /**
     * 用户注销
     * @param request
     * @return
     */
    @PostMapping("/logout")
    private CommonResult userLogout(HttpServletRequest request) {
        userService.userLogout(request);
        return CommonResult.success();
    }

    /**
     * 根据条件分页查询用户脱敏信息
     * @param userQueryDTO
     * @return
     */
    @PostMapping("/list/page/vo")
    private PageResult<UserVO> listUserVOByPage(@RequestBody UserQueryDTO userQueryDTO) {
        if (userQueryDTO == null) {
            CommonResult.error(HttpStatus.PARAMS_ERROR, "参数错误");
        }
        return userService.getUserVOPage(userQueryDTO);
    }

    /**
     * 更新用户信息
     * @param userUpdateDTO
     * @return
     */
    @PutMapping("/")
    private CommonResult updateUser(@RequestBody UserUpdateDTO userUpdateDTO) {
        if (userUpdateDTO == null) {
            CommonResult.error(HttpStatus.PARAMS_ERROR, "更新用户信息参数错误");
        }
        userService.updateUser(userUpdateDTO);
        return CommonResult.success();
    }

}
