package com.lyanba.controller;


import com.lyanba.entry.UmsAdmin;
import com.lyanba.service.UmsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/list")
    List<UmsAdmin> list() {
        return umsAdminService.list();
    }
}

