package cn.elitecode.common.exception.file;

import cn.elitecode.common.exception.BaseException;

public class FileUploadErrorException extends BaseException {
    public FileUploadErrorException() {
    }

    public FileUploadErrorException(int code, String msg) {
        super(code, msg);
    }
}
