package com.lyanba.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @className: AdminExceptionHandler
 * @description: 统一异常处理
 * @author: LyanbA
 * @since: 2021/10/10 20:30
 * @todo:
 */
@RestControllerAdvice
public class AdminExceptionHandler {
    @ExceptionHandler
    String defaultExceptionHandler(Exception e) {
        return e.getMessage();
    }
}
