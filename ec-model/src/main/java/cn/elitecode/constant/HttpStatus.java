package cn.elitecode.constant;

/**
 * 自定义错误码
 */
public interface HttpStatus {

    /**
     * 操作成功
     */
    Integer SUCCESS = 200;

    /**
     * 请求参数错误
     */
    Integer PARAMS_ERROR = 40000;

    /**
     * 不允许操作管理员错误
     */
    Integer ADMIN_NOT_ALLOWED_ERROR = 40300;

    /**
     * 系统内部错误
     */
    Integer SYSTEM_ERROR = 500;

}
