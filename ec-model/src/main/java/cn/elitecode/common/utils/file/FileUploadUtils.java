package cn.elitecode.common.utils.file;

import cn.elitecode.common.BaseContext;
import cn.elitecode.common.exception.file.FileNameLengthExceedException;
import cn.elitecode.common.exception.file.FileSizeLimitExceededException;
import cn.elitecode.common.exception.file.FileUploadErrorException;
import cn.elitecode.common.exception.file.InvalidExtensionException;
import cn.elitecode.common.properties.FileUploadProperties;
import cn.elitecode.constant.HttpStatus;
import cn.hutool.core.io.file.FileNameUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.IdUtil;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * 文件上传工具类
 */
public class FileUploadUtils {

    /**
     * 默认上传文件最大大小 50M
     */
    public static final long DEFAULT_MAX_SIZE = 50 * 1024 * 1024;

    /**
     * 默认文件名最大长度 100
     */
    public static final long DEFAULT_MAX_FILE_NAME_LENGTH = 100;

    public static final String upload(String baseDir, MultipartFile file, String[] allowedExtension) {
        validFile(file, allowedExtension);
        String newFileName = IdUtil.simpleUUID() + "-" + file.getOriginalFilename();
        // 上传目录，根据用户划分
        String uploadDir = baseDir + File.separator + BaseContext.getCurrentId();
        File uploadFile = new File(uploadDir, newFileName);
        if (!uploadFile.exists()) {
            if (!uploadFile.getParentFile().exists()) {
                uploadFile.getParentFile().mkdirs();
            }
        }
        try {
            // 文件上传
            file.transferTo(new File(uploadDir, newFileName));
        } catch (IOException e) {
            throw new FileUploadErrorException(HttpStatus.SYSTEM_ERROR, "文件上传失败");
        }
        // 返回资源映射路径
        int startIndex = FileUploadProperties.getUploadPath().length() + 1;
        String currentPath = uploadDir.substring(startIndex);
        return FileUploadProperties.getResourcePrefix() + currentPath + "/" + newFileName;
    }

    /**
     * 校验文件是否合法
     * @param file
     * @param allowedExtension
     */
    private static void validFile(MultipartFile file, String[] allowedExtension) {
        // 判断文件大小是否超出
        long size = file.getSize();
        if (size > DEFAULT_MAX_SIZE) {
            throw new FileSizeLimitExceededException(HttpStatus.PARAMS_ERROR, "文件大小不能超过 " + DEFAULT_MAX_SIZE + " M");
        }

        // 判断文件名长度是否超出
        int fileNameLength = Objects.requireNonNull(file.getOriginalFilename()).length();
        if (fileNameLength > DEFAULT_MAX_FILE_NAME_LENGTH) {
            throw new FileNameLengthExceedException(HttpStatus.PARAMS_ERROR, "文件名长度不能超过 " + DEFAULT_MAX_FILE_NAME_LENGTH);
        }

        // 判断上传的文件格式是否合法
        String fileName = file.getOriginalFilename();
        String extension = FileNameUtil.getSuffix(file.getOriginalFilename()); // 获取后缀名
        if (allowedExtension == null || !ArrayUtil.contains(allowedExtension, extension)) {
            if (allowedExtension == MimeTypeUtils.IMAGE_EXTENSION) {
                throw new InvalidExtensionException.InvalidImageExtensionException(allowedExtension, extension, fileName);
            } else if (allowedExtension == MimeTypeUtils.FLASH_EXTENSION) {
                throw new InvalidExtensionException.InvalidFlashExtensionException(allowedExtension, extension, fileName);
            } else if (allowedExtension == MimeTypeUtils.MEDIA_EXTENSION) {
                throw new InvalidExtensionException.InvalidMediaExtensionException(allowedExtension, extension, fileName);
            } else if (allowedExtension == MimeTypeUtils.VIDEO_EXTENSION) {
                throw new InvalidExtensionException.InvalidVideoExtensionException(allowedExtension, extension, fileName);
            } else {
                throw new InvalidExtensionException(allowedExtension, extension, fileName);
            }
        }
    }

}
