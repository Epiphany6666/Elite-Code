package cn.elitecode.exception.user;

import cn.elitecode.exception.BaseException;

/**
 * 注册失败异常
 */
public class RegistrationFailedException extends BaseException {
    public RegistrationFailedException() {
    }

    public RegistrationFailedException(int code, String msg) {
        super(code, msg);
    }
}
