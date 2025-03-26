package cn.elitecode.common.exception;

import cn.elitecode.common.api.CommonResult;
import cn.elitecode.constant.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理器
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(BaseException.class)
    public CommonResult handleBaseException(BaseException e, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        log.error("请求地址：{}，发生业务异常.", requestURI, e);
        return CommonResult.error(e.getCode(), e.getMessage());
    }

    /**
     * 自定义验证异常
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CommonResult handleMethodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
        String message = e.getBindingResult().getFieldError().getDefaultMessage();
        return CommonResult.error(HttpStatus.PARAMS_ERROR, message);
    }

    /**
     * 处理 JSON 解析异常（如空请求体、格式错误）
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public CommonResult handleHttpMessageNotReadableException(HttpMessageNotReadableException e, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        log.error("请求地址：{}，请求参数解析失败: {}", requestURI, e.getMessage());
        return CommonResult.error(HttpStatus.PARAMS_ERROR, "请求参数错误");
    }

    @ExceptionHandler(RuntimeException.class)
    public CommonResult handleRuntimeException(RuntimeException e, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        log.error("请求地址：{}，发生未知异常.", requestURI, e);
        return CommonResult.error(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public CommonResult handleException(Exception e, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        log.error("请求地址：{}，发生系统异常.", requestURI, e);
        return CommonResult.error(e.getMessage());
    }

}
