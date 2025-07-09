package cn.elitecode.module.infra.exception.file;

import cn.elitecode.framework.common.exception.BaseException;

public class FileSizeLimitExceededException extends BaseException {
    public FileSizeLimitExceededException() {
    }

    public FileSizeLimitExceededException(int code, String msg) {
        super(code, msg);
    }
}
