package cn.elitecode.common.exception.user;

import cn.elitecode.common.exception.BaseException;

/**
 * 用户账号未找到异常
 */
public class UsernameNotFoundException extends BaseException {

    public UsernameNotFoundException() {
    }

    public UsernameNotFoundException(int code, String msg) {
        super(code, msg);
    }
}
