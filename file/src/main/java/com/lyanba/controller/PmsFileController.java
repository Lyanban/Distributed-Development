package com.lyanba.controller;


import com.lyanba.service.PmsFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author LyanbA
 * @since 2021-10-12
 */
@RestController
@RequestMapping("/pms-file")
public class PmsFileController {
    @Autowired
    PmsFileService pmsFileService;

    @PostMapping("/fileUpload")
    String fileUpload(@RequestPart("file") MultipartFile multipartFile) throws Exception {
        return pmsFileService.fileUpload( multipartFile);
    }
}

