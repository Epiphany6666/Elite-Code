package cn.elitecode.common;

import cn.elitecode.constant.HttpStatus;
import cn.hutool.core.util.ObjectUtil;
import java.util.HashMap;

/**
 * 通用返回类
 * @param <T>
 */
public class CommonResult<T> extends HashMap<String, Object> {

    /**
     * 状态码
     */
    private static final String CODE_TAG = "code";

    /**
     * 信息
     */
    private static final String MSG_TAG = "msg";

    /**
     * 数据对象
     */
    private static final String DATA_TAG = "data";

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
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
        if (ObjectUtil.isNotEmpty(data)) {
            super.put(DATA_TAG, data);
        }
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
    public static <T> CommonResult<T> error(int code, String msg) {
        return new CommonResult(code, msg, null);
    }

}
