package cn.elitecode.framework.common.enums;

/**
 * 自定义错误码
 */
public interface HttpStatus {

    /**
     * 操作成功
     */
    int SUCCESS = 200;

    /**
     * 请求参数错误
     */
    int PARAMS_ERROR = 40000;

    /**
     * 不允许操作管理员错误
     */
    int ADMIN_NOT_ALLOWED_ERROR = 40300;

    /**
     * 系统内部错误
     */
    int SYSTEM_ERROR = 500;

}
