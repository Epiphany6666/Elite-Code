package cn.elitecode.module.infra.exception.file;


import cn.elitecode.framework.common.exception.BaseException;

public class FileNameLengthExceedException extends BaseException {
    public FileNameLengthExceedException() {
    }

    public FileNameLengthExceedException(int code, String msg) {
        super(code, msg);
    }
}
