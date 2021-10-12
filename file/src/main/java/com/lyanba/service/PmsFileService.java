package com.lyanba.service;

import com.lyanba.entry.PmsFile;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author LyanbA
 * @since 2021-10-12
 */
public interface PmsFileService extends IService<PmsFile> {
    String fileUpload(MultipartFile file) throws Exception;
}
