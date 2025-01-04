package cn.elitecode.common.exception.file;

import cn.elitecode.common.exception.BaseException;

public class FileSizeLimitExceededException extends BaseException {
    public FileSizeLimitExceededException() {
    }

    public FileSizeLimitExceededException(int code, String msg) {
        super(code, msg);
    }
}
