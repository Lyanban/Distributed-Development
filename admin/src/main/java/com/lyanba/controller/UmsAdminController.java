package com.lyanba.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lyanba.entry.ResultJson;
import com.lyanba.entry.UmsAdmin;
import com.lyanba.service.FileService;
import com.lyanba.service.UmsAdminService;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.errors.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author LyanbA
 * @since 2021-10-09
 */
@RestController
@RequestMapping("/ums-admin")
public class UmsAdminController {
    @Autowired
    UmsAdminService umsAdminService;

    @Autowired
    FileService fileService;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    /*@GetMapping("/list")
    List<UmsAdmin> list() {
        return umsAdminService.list();
    }*/

    // 添加分页功能
    /*@GetMapping("/list")
    Page<UmsAdmin> list(int pageNo, int pageSize) throws InterruptedException {
        // 模拟网络延时
        TimeUnit.SECONDS.sleep(1);
        int a = 1 / 0;
        return umsAdminService.page(new Page<>(pageNo, pageSize));
    }*/

    // 优化分页查询，使用封装的返回结果 ResultJson
    /*@GetMapping("/list")
    ResultJson<Page<UmsAdmin>> list(int pageNo, int pageSize) {
        return ResultJson.success(umsAdminService.page(new Page<>(pageNo, pageSize)));
    }*/

    // 添加条件查询
    @GetMapping("/list")
    ResultJson<Page<UmsAdmin>> list(int pageNo, int pageSize, String search) {
        return ResultJson.success(umsAdminService.list(pageNo, pageSize, search));
    }

    // 新增用户
    /*@PostMapping("/save")
    ResultJson<Boolean> saveUmsAdmin(UmsAdmin umsAdmin) {
        return ResultJson.success(umsAdminService.save(umsAdmin), "新增用户成功");
    }*/

    // 优化新增用户功能，新增上传头像功能
    /*@PostMapping("/save")
    ResultJson<Boolean> saveUmsAdmin(UmsAdmin umsAdmin, MultipartFile file) throws Exception {
        // 使用 MinIO 服务的 URL，端口，Access key 和 Secret key 创建一个 MinioClient 对象
        MinioClient minioClient = MinioClient.builder()
                .endpoint("http://192.168.0.110:9000/")
                .credentials("root", "rootroot")
                .build();
        *//*
            bucket -> MinIO 图片服务器建立的桶
            object -> 要上传的文件名
            contentType -> 要上传的文件后缀名/文件类型
            stream -> 要上传的文件流
         *//*
        PutObjectArgs args = PutObjectArgs.builder()
                .bucket("images")
                .object(file.getOriginalFilename())
                .contentType(file.getContentType())
                .stream(file.getInputStream(), file.getSize(), 0)
                .build();
        minioClient.putObject(args);
        return ResultJson.success(null, "新增用户成功");
    }*/

    // 头像上传改为远程调用上传到 MinIO 图片服务器
    /*@PostMapping("/save")
    ResultJson<Boolean> saveUmsAdmin(UmsAdmin umsAdmin, MultipartFile file) throws Exception {
        umsAdmin.setImage(fileService.fileUpload(file));
        return ResultJson.success(umsAdminService.save(umsAdmin), "新增用户成功");
    }*/

    // 优化新增用户，支持密码加密
    @PostMapping("/save")
    ResultJson<Boolean> saveUmsAdmin(UmsAdmin umsAdmin, MultipartFile file) throws Exception {
        umsAdmin.setPassword(passwordEncoder.encode(umsAdmin.getRawPassword()));
        umsAdmin.setImage(fileService.fileUpload(file));
        return ResultJson.success(umsAdminService.save(umsAdmin), "新增用户成功");
    }

    // 根据 id 获取 UmsAdmin 对象
    @GetMapping("/getAdminById")
    ResultJson<UmsAdmin> getUmsAdminById(Long id) {
        return ResultJson.success(umsAdminService.getById(id));
    }

    // 更新用户
   /* @PutMapping("/update")
    ResultJson<Boolean> updateUmsAdminById(UmsAdmin umsAdmin) {
        return ResultJson.success(umsAdminService.updateById(umsAdmin), "更新用户成功");
    }*/

    // 优化更新用户头像部分，若更新时没有上传图片，则视为不更新头像
    @PutMapping("/update")
    ResultJson<Boolean> updateUmsAdminById(UmsAdmin umsAdmin, MultipartFile file) {
        // 判断用户是否上传了头像
        if (null != file && 0 < file.getSize()) {
            umsAdmin.setImage(fileService.fileUpload(file));
        }
        return ResultJson.success(umsAdminService.updateById(umsAdmin), "更新用户成功");
    }

    @PutMapping("/delete")
    ResultJson<Boolean> deleteUmsAdminById(UmsAdmin umsAdmin) {
        return ResultJson.success(umsAdminService.updateById(umsAdmin), umsAdmin.getActive() == 0 ? "删除用户成功" : "恢复用户成功");
    }

    // 添加验证用户信息功能，添加用户是检查邮箱、手机是否已被注册
    @GetMapping("/check")
    ResultJson<Integer> checkEmailPhone(Long id, String text) {
        return ResultJson.success(umsAdminService.check(id, text));
    }
}

