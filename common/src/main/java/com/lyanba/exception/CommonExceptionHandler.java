package com.lyanba.exception;

import com.lyanba.entry.ResultJson;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @className: CommonExceptionHandler
 * @description:
 * @author: LyanbA
 * @since: 2021/10/14 13:00
 * @todo:
 */
@RestControllerAdvice
public class CommonExceptionHandler {
    // 使用封装的返回结果 ResultJson
    @ExceptionHandler
    ResultJson<String> defaultExceptionHandler(Exception e) {
        return ResultJson.failed(e.getMessage());
    }
}
