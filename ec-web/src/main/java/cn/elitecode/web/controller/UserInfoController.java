package cn.elitecode.web.controller;

import cn.elitecode.common.BaseContext;
import cn.elitecode.common.CommonResult;
import cn.elitecode.common.properties.FileUploadProperties;
import cn.elitecode.common.utils.file.FileUploadUtils;
import cn.elitecode.common.utils.file.MimeTypeUtils;
import cn.elitecode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/user/profile")
public class UserInfoController {

    @Autowired
    private UserService userService;

    @PostMapping("/avatar")
    private CommonResult<String> avatar(MultipartFile avatarFile) {
        String avatarUrl = FileUploadUtils.upload(FileUploadProperties.getAvatarPath(), avatarFile, MimeTypeUtils.IMAGE_EXTENSION);
        if (!userService.updateUserAvatar(BaseContext.getCurrentId(), avatarUrl)) {
            return CommonResult.error("头像上传失败");
        }
        return CommonResult.success(avatarUrl);
    }

}
