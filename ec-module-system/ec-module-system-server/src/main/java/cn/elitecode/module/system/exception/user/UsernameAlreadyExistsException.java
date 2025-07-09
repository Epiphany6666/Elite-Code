package cn.elitecode.module.system.exception.user;

import cn.elitecode.framework.common.exception.BaseException;

/**
 * 用户账号已存在异常
 */
public class UsernameAlreadyExistsException extends BaseException {

    public UsernameAlreadyExistsException() {
    }

    public UsernameAlreadyExistsException(int code, String msg) {
        super(code, msg);
    }
}
