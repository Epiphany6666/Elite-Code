package cn.elitecode.web.controller;

import cn.elitecode.common.BaseContext;
import cn.elitecode.common.CommonResult;
import cn.elitecode.common.PageResult;
import cn.elitecode.common.properties.FileUploadProperties;
import cn.elitecode.common.properties.JWTProperties;
import cn.elitecode.common.utils.file.FileUploadUtils;
import cn.elitecode.common.utils.file.MimeTypeUtils;
import cn.elitecode.constant.HttpStatus;
import cn.elitecode.model.bo.LoginUser;
import cn.elitecode.model.dto.user.*;
import cn.elitecode.model.entity.User;
import cn.elitecode.model.vo.LoginUserVO;
import cn.elitecode.model.vo.UserVO;
import cn.elitecode.service.UserService;
import cn.hutool.core.util.ArrayUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * 用户控制器
 */
@Api(tags = "UserController", description = "用户管理")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @ApiOperation(value = "用户登录")
    @PostMapping("/login")
    private CommonResult<LoginUserVO> login(@RequestBody @Validated UserLoginDTO userLoginDTO) {
        String username = userLoginDTO.getUsername();
        String userPassword = userLoginDTO.getPassword();
        String tokenHead = JWTProperties.getTokenHead();
        String token = userService.login(username, userPassword);
        LoginUserVO loginUserVO = new LoginUserVO(tokenHead, token);
        return CommonResult.success(loginUserVO);
    }

    @ApiOperation(value = "用户注册")
    @PostMapping("/register")
    private CommonResult<Long> register(@RequestBody @Validated UserRegisterDTO userRegisterDTO) {
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
        user.setPassword(passwordEncoder.encode(userPassword));
        Long registerUserId = userService.register(user);
        return CommonResult.success(registerUserId);
    }

    @ApiOperation(value = "用户注销")
    @PostMapping("/logout")
    private CommonResult userLogout() {
        userService.userLogout();
        return CommonResult.success();
    }

    @ApiOperation(value = "根据条件分页查询用户脱敏信息")
    @PostMapping("/list/page/vo")
    private PageResult<UserVO> listUserVOByPage(@RequestBody UserQueryDTO userQueryDTO) {
        return userService.getUserVOPage(userQueryDTO);
    }

    @ApiOperation(value = "新增用户")
    @PostMapping("/")
    private CommonResult addUser(@RequestBody UserAddDTO userAddDTO) {
        User user = new User();
        BeanUtils.copyProperties(userAddDTO, user);
        if (!userService.checkUsernameUnique(user)) {
            return CommonResult.error(HttpStatus.PARAMS_ERROR, "新增用户 '" + user.getUsername() + "' 失败，账号已存在");
        }
        user.setCreateBy(BaseContext.getCurrentId());
        user.setPassword(passwordEncoder.encode(userAddDTO.getPassword()));
        return CommonResult.success(userService.addUser(user));
    }

    @ApiOperation(value = "管理员根据用户id更新用户信息")
    @PutMapping("/")
    private CommonResult updateUser(@RequestBody UserUpdateDTO userUpdateDTO) {
        User user = new User();
        BeanUtils.copyProperties(userUpdateDTO, user);
        userService.updateUser(user);
        return CommonResult.success();
    }

    @ApiOperation(value = "更新个人信息")
    @PutMapping("/profile")
    private CommonResult updateProfile(@RequestBody UserUpdateProfileDto updateProfileDto) {
        LoginUser loginUser = userService.getLoginUser();
        User user = new User(loginUser.getUser().getId());
        BeanUtils.copyProperties(updateProfileDto, user);
        userService.updateUser(user);
        return CommonResult.success();
    }

    @ApiOperation(value = "获取用户信息")
    @GetMapping("/getInfo")
    private CommonResult<UserVO> getInfo() {
        LoginUser loginUser = userService.getLoginUser();
        UserVO userVO = userService.getUserVOById(loginUser.getUser().getId());
        return CommonResult.success(userVO);
    }

    @ApiOperation(value = "批量删除用户")
    @DeleteMapping("/{userIds}")
    private CommonResult remove(@ApiParam(value = "需要删除的id数组") @PathVariable Long[] userIds) {
        Long id = BaseContext.getCurrentId();
        if (ArrayUtil.contains(userIds, id)) {
            return CommonResult.error(HttpStatus.PARAMS_ERROR, "不能删除当前用户");
        }
        userService.removeByUserIds(userIds);
        return CommonResult.success();
    }

    @ApiOperation(value = "头像上传")
    @PostMapping("/profile/avatar")
    private CommonResult<String> avatar(MultipartFile avatarFile) {
        String avatarUrl = FileUploadUtils.upload(FileUploadProperties.getAvatarPath(), avatarFile, MimeTypeUtils.IMAGE_EXTENSION);
        if (!userService.updateUserAvatar(BaseContext.getCurrentId(), avatarUrl)) {
            return CommonResult.error("头像上传失败");
        }
        return CommonResult.success(avatarUrl);
    }

}
