package cn.luoyan.elitecode.common.exception.user;

import cn.luoyan.elitecode.common.exception.BaseException;

public class UserAccountNotFoundException extends BaseException {

    public UserAccountNotFoundException() {
    }

    public UserAccountNotFoundException(int code, String msg) {
        super(code, msg);
    }
}
