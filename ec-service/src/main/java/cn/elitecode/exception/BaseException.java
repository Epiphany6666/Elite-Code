package cn.elitecode.exception;

/**
 * 封装自定义异常类
 */
public class BaseException extends RuntimeException {

    /**
     * 错误码
     */
    private Integer code;

    public BaseException() {
    }

    public BaseException(int code, String msg) {
        super(msg);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
