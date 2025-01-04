package cn.elitecode.common.exception.user;

import cn.elitecode.common.exception.BaseException;

public class AdminNotAllowedException extends BaseException {
    public AdminNotAllowedException() {
    }

    public AdminNotAllowedException(int code, String msg) {
        super(code, msg);
    }
}
