package com.lyanba.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: TestController
 * @description:
 * @author: LyanbA
 * @since: 2021/10/12 18:37
 * @todo:
 */
@RestController
public class TestController {
    @GetMapping("/hello")
    String hello() {
        return "file hello";
    }
}
