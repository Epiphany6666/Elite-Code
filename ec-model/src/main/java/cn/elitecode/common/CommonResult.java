package cn.elitecode.common;

import cn.elitecode.constant.HttpStatus;
import io.swagger.annotations.ApiModelProperty;

/**
 * 通用返回类
 * @param <T>
 */
public class CommonResult<T> {

    @ApiModelProperty(value = "状态码")
    private int code;

    @ApiModelProperty(value = "信息")
    private String msg;

    @ApiModelProperty(value = "数据对象")
    private T data;

    /**
     * 初始化一个新创建的 CommonResult 对象，使其表示一个空消息
     */
    public CommonResult() {
    }

    /**
     * 初始化一个新创建的 CommonResult 对象
     * @param code 状态码
     * @param msg 信息
     */
    public CommonResult(int code, String msg) {
        this(code, msg, null);
    }

    /**
     * 初始化一个新创建的 CommonResult 对象
     * @param code 状态码
     * @param msg 信息
     * @param data 数据对象
     */
    public CommonResult(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 返回成功消息
     * @return 成功消息
     */
    public static CommonResult success() {
        return CommonResult.success(null);
    }

    /**
     * 返回成功消息
     * @param data 数据对象
     * @return 成功消息
     */
    public static <T> CommonResult<T> success(T data) {
        return new CommonResult(HttpStatus.SUCCESS, "操作成功", data);
    }

    /**
     * 返回错误消息
     * @param msg 错误信息
     * @return 错误消息
     */
    public static CommonResult error(String msg) {
        return new CommonResult(HttpStatus.SYSTEM_ERROR, msg);
    }

    /**
     * 返回错误消息
     * @param code 状态码
     * @param msg 错误信息
     * @return 错误消息
     */
    public static CommonResult error(int code, String msg) {
        return new CommonResult(code, msg, null);
    }

    /**
     * 获取
     * @return code
     */
    public int getCode() {
        return code;
    }

    /**
     * 设置
     * @param code
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * 获取
     * @return msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * 设置
     * @param msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 获取
     * @return data
     */
    public T getData() {
        return data;
    }

    /**
     * 设置
     * @param data
     */
    public void setData(T data) {
        this.data = data;
    }

}
