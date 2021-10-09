package com.lyanba;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @className: AdminApp
 * @description:
 * @author: LyanbA
 * @since: 2021/10/9 17:06
 * @todo:
 */
@SpringBootApplication
@MapperScan(basePackages = "com.lyanba.mapper")
public class AdminApp {
    public static void main(String[] args) {
        SpringApplication.run(AdminApp.class, args);
    }
}
