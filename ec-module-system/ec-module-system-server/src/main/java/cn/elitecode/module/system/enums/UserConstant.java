package cn.elitecode.module.system.enums;

/**
 * 用户常量信息
 */
public interface UserConstant {

    /**
     * 校验是否唯一的返回标识
     */
    boolean NOT_UNIQUE = false;
    boolean UNIQUE = true;

    /**
     * 用户账号长度限制
     */
    int USER_ACCOUNT_MIN_LENGTH = 2;
    int USER_ACCOUNT_MAX_LENGTH = 20;

    /**
     * 用户密码长度限制
     */
    int USER_PASSWORD_MIN_LENGTH = 6;
    int USER_PASSWORD_MAX_LENGTH = 20;

}
