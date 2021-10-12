package com.lyanba.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lyanba.entry.PmsFile;
import com.lyanba.mapper.PmsFileMapper;
import com.lyanba.service.PmsFileService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author LyanbA
 * @since 2021-10-12
 */
@Service
public class PmsFileServiceImpl extends ServiceImpl<PmsFileMapper, PmsFile> implements PmsFileService {
    // 配置中心中的数据
    @Value("${minio.endpoint}")
    String endpoint;
    @Value("${minio.accessKey}")
    String accessKey;
    @Value("${minio.secretKey}")
    String secretKey;

    @Override
    public String fileUpload(MultipartFile multipartFile) throws Exception {
        // 获取文件的 MD5
        String md5 = DigestUtils.md5Hex(multipartFile.getBytes());
        long size = multipartFile.getSize();
        String suffix = FilenameUtils.getExtension(multipartFile.getOriginalFilename());

        // 判断相同的 md5 + size + suffix 是否存在
        QueryWrapper<PmsFile> wrapper = new QueryWrapper<>();
        wrapper.eq("md5", md5).eq("size", size).eq("suffix", suffix);
        PmsFile pmsFile = this.getOne(wrapper);
        if (null != pmsFile) {
            // 如果存在，则直接返回文件的路径
            return pmsFile.getPath();
        }

        // 为上传的文件定义一个新的唯一的名字
        StringBuilder stringBuilder = new StringBuilder();
        LocalDateTime currentTime = LocalDateTime.now();
        stringBuilder.append(currentTime.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS")))
                .append(RandomStringUtils.random(6, false, true))
                .append(".")
                .append(suffix);

        /*MinioClient minioClient = MinioClient.builder()
                .endpoint("http://192.168.0.110:9000")
                .credentials("root", "rootroot")
                .build();*/

        // 使用配置中心中
        MinioClient minioClient = MinioClient.builder()
                .endpoint(endpoint)
                .credentials(accessKey, secretKey)
                .build();
        /*
            bucket -> MinIO 图片服务器建立的桶
            object -> 要上传的文件名
            contentType -> 要上传的文件后缀名
            stream -> 要上传的文件流
         */
        PutObjectArgs args = PutObjectArgs.builder()
                .bucket("images")
                .object(stringBuilder.toString())
                .contentType(multipartFile.getContentType())
                .stream(multipartFile.getInputStream(), size, 0)
                .build();

        minioClient.putObject(args);

        pmsFile = new PmsFile();
        pmsFile.setMd5(md5).setSize(size).setSuffix(suffix).setPath(stringBuilder.toString());
        this.save(pmsFile);

        return stringBuilder.toString();
    }
}
