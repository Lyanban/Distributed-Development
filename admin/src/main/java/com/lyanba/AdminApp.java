package com.lyanba;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @className: AdminApp
 * @description:
 * @author: LyanbA
 * @since: 2021/10/9 17:06
 * @todo:
 */
@SpringBootApplication
@MapperScan(basePackages = "com.lyanba.mapper")
@EnableDiscoveryClient
@EnableFeignClients
public class AdminApp {
    public static void main(String[] args) {
        SpringApplication.run(AdminApp.class, args);
    }
}
