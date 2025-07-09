package cn.elitecode.module.system.exception.user;

import cn.elitecode.framework.common.exception.BaseException;

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
