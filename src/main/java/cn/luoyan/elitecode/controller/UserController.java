package cn.luoyan.elitecode.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.DigestUtil;
import cn.luoyan.elitecode.common.BaseContext;
import cn.luoyan.elitecode.common.CommonResult;
import cn.luoyan.elitecode.common.PageResult;
import cn.luoyan.elitecode.common.constant.HttpStatus;
import cn.luoyan.elitecode.common.constant.UserConstant;
import cn.luoyan.elitecode.model.dto.user.*;
import cn.luoyan.elitecode.model.entity.User;
import cn.luoyan.elitecode.model.vo.LoginUserVO;
import cn.luoyan.elitecode.model.vo.UserVO;
import cn.luoyan.elitecode.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
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
        if (StrUtil.isEmpty(userAccount)) {
            return CommonResult.error(HttpStatus.PARAMS_ERROR, "用户账号不能为空");
        }
        if (StrUtil.isEmpty(userPassword)) {
            return CommonResult.error(HttpStatus.PARAMS_ERROR, "用户密码不能为空");
        }
        if (userAccount.length() < UserConstant.USER_ACCOUNT_MIN_LENGTH
                || userAccount.length() > UserConstant.USER_ACCOUNT_MAX_LENGTH) {
            return CommonResult.error(HttpStatus.PARAMS_ERROR, "账号长度必须在2到20个字符之间");
        }
        if (userPassword.length() < UserConstant.USER_PASSWORD_MIN_LENGTH
                || userPassword.length() > UserConstant.USER_PASSWORD_MAX_LENGTH) {
            return CommonResult.error(HttpStatus.PARAMS_ERROR, "密码长度必须在6到20个字符之间");
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

        // 校验
        String userAccount = userRegisterDTO.getUserAccount();
        String userPassword = userRegisterDTO.getUserPassword();
        String checkPassword = userRegisterDTO.getCheckPassword();
        if (StringUtils.isEmpty(userAccount)) {
            return CommonResult.error(HttpStatus.PARAMS_ERROR, "用户账号不能为空");
        }
        if (StringUtils.isEmpty(userPassword)) {
            return CommonResult.error(HttpStatus.PARAMS_ERROR, "用户密码不能为空");
        }
        if (StringUtils.isEmpty(checkPassword)) {
            return CommonResult.error(HttpStatus.PARAMS_ERROR, "校验密码不能为空");
        }
        if (userAccount.length() < UserConstant.USER_ACCOUNT_MIN_LENGTH
                || userAccount.length() > UserConstant.USER_ACCOUNT_MAX_LENGTH) {
            return CommonResult.error(HttpStatus.PARAMS_ERROR, "账号长度必须在2到20个字符之间");
        }
        if (userPassword.length() < UserConstant.USER_PASSWORD_MIN_LENGTH
                || userPassword.length() > UserConstant.USER_PASSWORD_MAX_LENGTH) {
            return CommonResult.error(HttpStatus.PARAMS_ERROR, "密码长度必须在6到20个字符之间");
        }
        if (!userPassword.equals(checkPassword)) {
            return CommonResult.error(HttpStatus.PARAMS_ERROR, "两次输入的密码不一致");
        }
        User user = new User();
        user.setUserAccount(userRegisterDTO.getUserAccount());
        if (!userService.checkUserAccountUnique(user)) {
            return CommonResult.error(HttpStatus.PARAMS_ERROR, "用户注册 '" + user.getUserAccount() + "' 失败，账号已存在");
        }
        user.setUserPassword(DigestUtils.md5DigestAsHex((UserConstant.SALT + userPassword).getBytes()));
        Long registerUserId = userService.register(user);
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
     * 新增用户
     * @param userAddDTO
     * @return
     */
    @PostMapping("/")
    private CommonResult addUser(@RequestBody UserAddDTO userAddDTO) {
        if (userAddDTO == null) {
            CommonResult.error(HttpStatus.PARAMS_ERROR, "新增用户参数错误");
        }
        User user = new User();
        BeanUtils.copyProperties(userAddDTO, user);
        if (!userService.checkUserAccountUnique(user)) {
            return CommonResult.error(HttpStatus.PARAMS_ERROR, "新增用户 '" + user.getUserAccount() + "' 失败，账号已存在");
        }
        user.setCreateBy(BaseContext.getCurrentId());
        user.setUserPassword(DigestUtil.md5Hex((UserConstant.SALT + user.getUserPassword()).getBytes()));
        return CommonResult.success(userService.addUser(user));
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
