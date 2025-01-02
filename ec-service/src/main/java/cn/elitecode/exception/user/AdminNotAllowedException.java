package cn.elitecode.exception.user;

import cn.elitecode.exception.BaseException;

public class AdminNotAllowedException extends BaseException {
    public AdminNotAllowedException() {
    }

    public AdminNotAllowedException(int code, String msg) {
        super(code, msg);
    }
}
