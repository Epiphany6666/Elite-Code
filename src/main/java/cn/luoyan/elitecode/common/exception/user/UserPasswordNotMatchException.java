package cn.luoyan.elitecode.common.exception.user;

import cn.luoyan.elitecode.common.exception.BaseException;

/**
 * 用户密码不匹配异常
 */
public class UserPasswordNotMatchException extends BaseException {
    public UserPasswordNotMatchException() {
    }

    public UserPasswordNotMatchException(int code, String msg) {
        super(code, msg);
    }
}
