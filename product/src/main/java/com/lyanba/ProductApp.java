package com.lyanba;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @className: ProductApp
 * @description:
 * @author: LyanbA
 * @since: 2021/10/14 13:18
 * @todo:
 */
@SpringBootApplication
@MapperScan("com.lyanba.mapper")
@EnableDiscoveryClient
@EnableFeignClients
public class ProductApp {
    public static void main(String[] args) {
        SpringApplication.run(ProductApp.class, args);
    }
}
