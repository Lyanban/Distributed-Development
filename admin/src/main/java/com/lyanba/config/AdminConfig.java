package com.lyanba.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @className: AdminConfig
 * @description:
 * @author: LyanbA
 * @since: 2021/10/10 00:34
 * @todo:
 */
@Configuration
public class AdminConfig {
    /**
     * 解决项目的跨域问题
     */
    @Bean
    CorsFilter getCorsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        // 允许访问的域名
        config.addAllowedOrigin("*");
        // 允许的请求头
        config.addAllowedHeader("*");
        // 允许的请求方式
        config.addAllowedMethod("*");
        // 第一个参数表示要过滤的地址
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
