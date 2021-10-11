package com.lyanba.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lyanba.entry.ResultJson;
import com.lyanba.entry.UmsAdmin;
import com.lyanba.service.UmsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
    @PostMapping("/save")
    ResultJson<Boolean> saveUmsAdmin(UmsAdmin umsAdmin) {
        return ResultJson.success(umsAdminService.save(umsAdmin), "新增用户成功");
    }
}

