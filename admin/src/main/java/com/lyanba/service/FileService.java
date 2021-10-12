package com.lyanba.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @className: FileService
 * @description:
 * @author: LyanbA
 * @since: 2021/10/12 18:40
 * @todo:
 */
@FeignClient("file")
public interface FileService {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    String hello();
}
