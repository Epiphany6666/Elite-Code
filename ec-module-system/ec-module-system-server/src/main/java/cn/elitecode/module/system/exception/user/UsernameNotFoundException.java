package cn.elitecode.module.system.exception.user;

import cn.elitecode.framework.common.exception.BaseException;

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
