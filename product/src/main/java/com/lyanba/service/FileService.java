package com.lyanba.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

/**
 * @className: FileService
 * @description:
 * @author: LyanbA
 * @since: 2021/10/12 18:40
 * @todo:
 */
@FeignClient("file")
public interface FileService {
    @RequestMapping(value = "/pms-file/fileUpload",
            method = RequestMethod.POST,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String fileUpload(MultipartFile multipartFile);
}
