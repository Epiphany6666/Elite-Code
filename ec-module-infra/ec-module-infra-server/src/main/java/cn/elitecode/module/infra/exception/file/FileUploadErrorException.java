package cn.elitecode.module.infra.exception.file;

import cn.elitecode.framework.common.exception.BaseException;

public class FileUploadErrorException extends BaseException {
    public FileUploadErrorException() {
    }

    public FileUploadErrorException(int code, String msg) {
        super(code, msg);
    }
}
