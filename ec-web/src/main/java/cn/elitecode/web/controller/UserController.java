package cn.elitecode.web.controller;

import cn.elitecode.common.BaseContext;
import cn.elitecode.common.CommonResult;
import cn.elitecode.common.PageResult;
import cn.elitecode.common.properties.JWTProperties;
import cn.elitecode.constant.HttpStatus;
import cn.elitecode.constant.UserConstant;
import cn.elitecode.model.dto.user.*;
import cn.elitecode.model.entity.User;
import cn.elitecode.model.bo.LoginUser;
import cn.elitecode.model.vo.UserVO;
import cn.elitecode.service.UserService;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * 用户控制器
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 用户登录
     * @param userLoginDTO
     * @param request
     * @return
     */
    @PostMapping("/login")
    private CommonResult<HashMap> login(@RequestBody UserLoginDTO userLoginDTO, HttpServletRequest request) {
        if (userLoginDTO == null) {
            return CommonResult.error(HttpStatus.PARAMS_ERROR, "登录参数错误");
        }
        String username = userLoginDTO.getUsername();
        String userPassword = userLoginDTO.getPassword();

        // 校验
        if (StrUtil.isEmpty(username)) {
            return CommonResult.error(HttpStatus.PARAMS_ERROR, "用户账号不能为空");
        }
        if (StrUtil.isEmpty(userPassword)) {
            return CommonResult.error(HttpStatus.PARAMS_ERROR, "用户密码不能为空");
        }
        if (username.length() < UserConstant.USER_ACCOUNT_MIN_LENGTH
                || username.length() > UserConstant.USER_ACCOUNT_MAX_LENGTH) {
            return CommonResult.error(HttpStatus.PARAMS_ERROR, "账号长度必须在2到20个字符之间");
        }
        if (userPassword.length() < UserConstant.USER_PASSWORD_MIN_LENGTH
                || userPassword.length() > UserConstant.USER_PASSWORD_MAX_LENGTH) {
            return CommonResult.error(HttpStatus.PARAMS_ERROR, "密码长度必须在6到20个字符之间");
        }

        String token = userService.login(username, userPassword, request);
        String tokenHead = JWTProperties.getTokenHead();
        HashMap<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
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
        String username = userRegisterDTO.getUsername();
        String userPassword = userRegisterDTO.getPassword();
        String checkPassword = userRegisterDTO.getCheckPassword();
        if (StrUtil.isEmpty(username)) {
            return CommonResult.error(HttpStatus.PARAMS_ERROR, "用户账号不能为空");
        }
        if (StrUtil.isEmpty(userPassword)) {
            return CommonResult.error(HttpStatus.PARAMS_ERROR, "用户密码不能为空");
        }
        if (StrUtil.isEmpty(checkPassword)) {
            return CommonResult.error(HttpStatus.PARAMS_ERROR, "校验密码不能为空");
        }
        if (username.length() < UserConstant.USER_ACCOUNT_MIN_LENGTH
                || username.length() > UserConstant.USER_ACCOUNT_MAX_LENGTH) {
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
        user.setUsername(userRegisterDTO.getUsername());
        if (!userService.checkUsernameUnique(user)) {
            return CommonResult.error(HttpStatus.PARAMS_ERROR, "用户注册 '" + user.getUsername() + "' 失败，账号已存在");
        }
        user.setPassword(passwordEncoder.encode(userPassword));
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
        if (!userService.checkUsernameUnique(user)) {
            return CommonResult.error(HttpStatus.PARAMS_ERROR, "新增用户 '" + user.getUsername() + "' 失败，账号已存在");
        }
        user.setCreateBy(BaseContext.getCurrentId());
        user.setPassword(passwordEncoder.encode(userAddDTO.getPassword()));
        return CommonResult.success(userService.addUser(user));
    }

    /**
     * 更新用户信息
     * 管理员根据用户id修改用户信息
     * @param userUpdateDTO
     * @return
     */
    @PutMapping("/")
    private CommonResult updateUser(@RequestBody UserUpdateDTO userUpdateDTO) {
        if (userUpdateDTO == null) {
            CommonResult.error(HttpStatus.PARAMS_ERROR, "更新用户信息参数错误");
        }
        if (userUpdateDTO.getId() == null) {
            CommonResult.error(HttpStatus.PARAMS_ERROR, "用户ID不能为空");
        }
        User user = new User();
        BeanUtils.copyProperties(userUpdateDTO, user);
        userService.updateUser(user);
        return CommonResult.success();
    }

    /**
     * 更新个人信息
     * @param updateProfileDto
     * @return
     */
    @PutMapping("/profile")
    private CommonResult updateProfile(@RequestBody UserUpdateProfileDto updateProfileDto) {
        if (updateProfileDto == null) {
            CommonResult.error(HttpStatus.PARAMS_ERROR, "更新个人信息参数错误");
        }
        LoginUser loginUser = userService.getLoginUser();
        User user = new User(loginUser.getUser().getId());
        BeanUtils.copyProperties(updateProfileDto, user);
        userService.updateUser(user);
        return CommonResult.success();
    }

    /**
     * 获取个人信息
     * @return
     */
    @GetMapping("/profle")
    private CommonResult<UserVO> profile() {
        LoginUser loginUser = userService.getLoginUser();
        UserVO userVO = userService.getUserVOById(loginUser.getUser().getId());
        return CommonResult.success(userVO);
    }

    /**
     * 批量删除用户
     * @param userIds 需要删除的id数组
     * @return 结果
     */
    @DeleteMapping("/{userIds}")
    private CommonResult remove(@PathVariable Long[] userIds) {
        Long id = BaseContext.getCurrentId();
        if (ArrayUtil.contains(userIds, id)) {
            return CommonResult.error(HttpStatus.PARAMS_ERROR, "不能删除当前用户");
        }
        userService.removeByUserIds(userIds);
        return CommonResult.success();
    }

}
