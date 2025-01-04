package cn.elitecode.common.exception.file;

import cn.elitecode.common.exception.BaseException;

public class FileNameLengthExceedException extends BaseException {
    public FileNameLengthExceedException() {
    }

    public FileNameLengthExceedException(int code, String msg) {
        super(code, msg);
    }
}
