package cn.elitecode.common.exception.role;

import cn.elitecode.common.exception.BaseException;

public class RoleAlreadyAssignException extends BaseException {

    public RoleAlreadyAssignException() {
    }

    public RoleAlreadyAssignException(int code, String msg) {
        super(code, msg);
    }

}
