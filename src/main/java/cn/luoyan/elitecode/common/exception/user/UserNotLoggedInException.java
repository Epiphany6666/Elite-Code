package cn.luoyan.elitecode.common.exception.user;

import cn.luoyan.elitecode.common.exception.BaseException;

public class UserNotLoggedInException extends BaseException {
    public UserNotLoggedInException() {
    }

    public UserNotLoggedInException(int code, String msg) {
        super(code, msg);
    }
}
