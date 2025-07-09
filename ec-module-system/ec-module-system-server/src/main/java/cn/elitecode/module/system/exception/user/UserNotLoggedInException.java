package cn.elitecode.module.system.exception.user;

import cn.elitecode.framework.common.exception.BaseException;

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
