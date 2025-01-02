package cn.elitecode.exception.user;

import cn.elitecode.exception.BaseException;

/**
 * 用户未登录异常
 */
public class UserNotLoggedInException extends BaseException {
    public UserNotLoggedInException() {
    }

    public UserNotLoggedInException(int code, String msg) {
        super(code, msg);
    }
}
