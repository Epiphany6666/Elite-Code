package cn.luoyan.elitecode.common.exception.user;

import cn.luoyan.elitecode.common.exception.BaseException;

public class UserPasswordNotMatchException extends BaseException {
    public UserPasswordNotMatchException() {
    }

    public UserPasswordNotMatchException(int code, String msg) {
        super(code, msg);
    }
}
