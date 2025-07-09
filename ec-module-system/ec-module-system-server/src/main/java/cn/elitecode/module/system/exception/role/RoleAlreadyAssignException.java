package cn.elitecode.module.system.exception.role;

import cn.elitecode.framework.common.exception.BaseException;

public class RoleAlreadyAssignException extends BaseException {

    public RoleAlreadyAssignException() {
    }

    public RoleAlreadyAssignException(int code, String msg) {
        super(code, msg);
    }

}
