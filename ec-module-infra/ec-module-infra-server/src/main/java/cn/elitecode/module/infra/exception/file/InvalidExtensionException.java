package cn.elitecode.module.infra.exception.file;

import cn.elitecode.framework.common.enums.HttpStatus;
import cn.elitecode.framework.common.exception.BaseException;

import java.util.Arrays;

public class InvalidExtensionException extends BaseException {

    public InvalidExtensionException() {
    }

    public InvalidExtensionException(String[] allowedExtension, String extension, String fileName) {
        super(HttpStatus.PARAMS_ERROR, "文件[" + fileName + "]后缀[" + extension + "]不正确，请上传" + Arrays.toString(allowedExtension) + "格式");
    }

    public static class InvalidImageExtensionException extends InvalidExtensionException {
        public InvalidImageExtensionException() {
        }

        public InvalidImageExtensionException(String[] allowedExtension, String extension, String fileName) {
            super(allowedExtension, extension, fileName);
        }
    }

    public static class InvalidFlashExtensionException extends InvalidExtensionException
    {
        private static final long serialVersionUID = 1L;

        public InvalidFlashExtensionException(String[] allowedExtension, String extension, String filename)
        {
            super(allowedExtension, extension, filename);
        }
    }

    public static class InvalidMediaExtensionException extends InvalidExtensionException
    {
        private static final long serialVersionUID = 1L;

        public InvalidMediaExtensionException(String[] allowedExtension, String extension, String filename)
        {
            super(allowedExtension, extension, filename);
        }
    }

    public static class InvalidVideoExtensionException extends InvalidExtensionException
    {
        private static final long serialVersionUID = 1L;

        public InvalidVideoExtensionException(String[] allowedExtension, String extension, String filename)
        {
            super(allowedExtension, extension, filename);
        }
    }

}
