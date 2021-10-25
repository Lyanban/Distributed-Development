package com.lyanba.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lyanba.entry.PmsBrand;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 品牌表 服务类
 * </p>
 *
 * @author LyanbA
 * @since 2021-10-14
 */
public interface PmsBrandService extends IService<PmsBrand> {
    Page<PmsBrand> list(int pageNo, int pageSize, String search);

    int check(Long id, String text);
}
