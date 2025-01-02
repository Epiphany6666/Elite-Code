package cn.elitecode.exception.user;

import cn.elitecode.exception.BaseException;

/**
 * 用户账号未找到异常
 */
public class UserAccountNotFoundException extends BaseException {

    public UserAccountNotFoundException() {
    }

    public UserAccountNotFoundException(int code, String msg) {
        super(code, msg);
    }
}
