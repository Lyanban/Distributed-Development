package com.lyanba.exception;

import com.lyanba.entry.ResultJson;
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
    /*@ExceptionHandler
    String defaultExceptionHandler(Exception e) {
        return e.getMessage();
    }*/

    // 使用封装的返回结果 ResultJson
    @ExceptionHandler
    ResultJson<String> defaultExceptionHandler(Exception e) {
        return ResultJson.failed(e.getMessage());
    }
}
