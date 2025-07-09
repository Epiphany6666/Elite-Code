package cn.elitecode.module.system.exception.user;

import cn.elitecode.framework.common.exception.BaseException;

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
