package cn.luoyan.elitecode.common;

import cn.luoyan.elitecode.common.constant.HttpStatus;
import org.apache.commons.lang3.ObjectUtils;

import java.util.HashMap;

/**
 * 通用返回类
 * @param <T>
 */
public class AjaxResult<T> extends HashMap<String, Object> {

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
     * 初始化一个新创建的 AjaxResult 对象，使其表示一个空消息
     */
    public AjaxResult() {
    }

    /**
     * 初始化一个新创建的 AjaxResult 对象
     * @param code 状态码
     * @param msg 信息
     */
    public AjaxResult(int code, String msg) {
        this(code, msg, null);
    }

    /**
     * 初始化一个新创建的 AjaxResult 对象
     * @param code 状态码
     * @param msg 信息
     * @param data 数据对象
     */
    public AjaxResult(int code, String msg, T data) {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
        if (ObjectUtils.isNotEmpty(data)) {
            super.put(DATA_TAG, data);
        }
    }

    /**
     * 返回成功消息
     * @return 成功消息
     */
    public static AjaxResult success() {
        return AjaxResult.success(null);
    }

    /**
     * 返回成功消息
     * @param data 数据对象
     * @return 成功消息
     */
    public static <T> AjaxResult<T> success(T data) {
        return new AjaxResult(HttpStatus.SUCCESS, "操作成功", data);
    }

    /**
     * 返回错误消息
     * @param msg 错误信息
     * @return 错误消息
     */
    public static AjaxResult error(String msg) {
        return new AjaxResult(HttpStatus.SYSTEM_ERROR, msg);
    }

    /**
     * 返回错误消息
     * @param code 状态码
     * @param msg 错误信息
     * @return 错误消息
     */
    public static <T> AjaxResult<T> error(int code, String msg) {
        return new AjaxResult(code, msg, null);
    }

}
