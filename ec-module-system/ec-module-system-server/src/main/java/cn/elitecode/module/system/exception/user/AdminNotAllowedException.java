package cn.elitecode.module.system.exception.user;

import cn.elitecode.framework.common.exception.BaseException;

public class AdminNotAllowedException extends BaseException {
    public AdminNotAllowedException() {
    }

    public AdminNotAllowedException(int code, String msg) {
        super(code, msg);
    }
}
