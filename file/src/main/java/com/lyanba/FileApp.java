package com.lyanba;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @className: FileApp
 * @description:
 * @author: LyanbA
 * @since: 2021/10/12 18:19
 * @todo:
 */
@SpringBootApplication
@MapperScan("com.lyanba.mapper")
@EnableDiscoveryClient
public class FileApp {
    public static void main(String[] args) {
        SpringApplication.run(FileApp.class, args);
    }
}
