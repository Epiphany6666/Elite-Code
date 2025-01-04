package cn.elitecode.common.exception.user;

import cn.elitecode.common.exception.BaseException;

/**
 * 用户账号已存在异常
 */
public class UserAccountAlreadyExistsException extends BaseException {

    public UserAccountAlreadyExistsException() {
    }

    public UserAccountAlreadyExistsException(int code, String msg) {
        super(code, msg);
    }
}
