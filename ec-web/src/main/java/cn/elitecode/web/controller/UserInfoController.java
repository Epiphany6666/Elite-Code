package cn.elitecode.web.controller;

import cn.elitecode.common.BaseContext;
import cn.elitecode.common.api.CommonResult;
import cn.elitecode.common.properties.FileUploadProperties;
import cn.elitecode.common.utils.file.FileUploadUtils;
import cn.elitecode.common.utils.file.MimeTypeUtils;
import cn.elitecode.model.dto.user.UserUpdateDTO;
import cn.elitecode.model.dto.user.UserUpdateProfileDto;
import cn.elitecode.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Api(tags = "UserInfoController", description = "个人信息管理")
@RestController("/user/profile")
public class UserInfoController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "更新个人信息")
    @PutMapping
    private CommonResult updateProfile(@RequestBody UserUpdateProfileDto userUpdateProfileDto) {
        UserUpdateDTO userUpdateDTO = new UserUpdateDTO();
        BeanUtils.copyProperties(userUpdateProfileDto, userUpdateDTO);
        userService.updateUser(userUpdateDTO);
        return CommonResult.success();
    }

    @ApiOperation(value = "头像上传")
    @PostMapping("/avatar")
    private CommonResult<String> avatar(MultipartFile avatarFile) {
        String avatarUrl = FileUploadUtils.upload(FileUploadProperties.getAvatarPath(), avatarFile, MimeTypeUtils.IMAGE_EXTENSION);
        if (!userService.updateUserAvatar(BaseContext.getCurrentId(), avatarUrl)) {
            return CommonResult.error("头像上传失败");
        }
        return CommonResult.success(avatarUrl);
    }

}
