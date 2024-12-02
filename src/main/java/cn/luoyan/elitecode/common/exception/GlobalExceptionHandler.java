package cn.luoyan.elitecode.common.exception;

import cn.luoyan.elitecode.common.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public AjaxResult handleBaseException(BaseException e, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        log.error("请求地址：{}，发生业务异常.", requestURI, e);
        return AjaxResult.error(e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public AjaxResult handleRuntimeException(RuntimeException e, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        log.error("请求地址：{}，发生未知异常.", requestURI, e);
        return AjaxResult.error(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public AjaxResult handleException(Exception e, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        log.error("请求地址：{}，发生系统异常.", requestURI, e);
        return AjaxResult.error(e.getMessage());
    }

}
