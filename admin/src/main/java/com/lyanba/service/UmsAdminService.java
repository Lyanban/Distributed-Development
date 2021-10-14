package com.lyanba.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lyanba.entry.UmsAdmin;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author LyanbA
 * @since 2021-10-09
 */
public interface UmsAdminService extends IService<UmsAdmin> {
    Page<UmsAdmin> list(int pageNo, int pageSize, String search);

    int check(Long id, String text);
}
