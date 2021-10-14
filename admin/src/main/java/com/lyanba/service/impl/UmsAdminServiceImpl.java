package com.lyanba.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lyanba.entry.UmsAdmin;
import com.lyanba.mapper.UmsAdminMapper;
import com.lyanba.service.UmsAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author LyanbA
 * @since 2021-10-09
 */
@Service
public class UmsAdminServiceImpl extends ServiceImpl<UmsAdminMapper, UmsAdmin> implements UmsAdminService {
    @Override
    public Page<UmsAdmin> list(int pageNo, int pageSize, String search) {
        QueryWrapper<UmsAdmin> wrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(search)) {
            wrapper.like("name", search).or().like("email", search).or().like("phone", search);
        }
        return page(new Page<>(pageNo, pageSize), wrapper);
    }

    @Override
    public int check(Long id, String text) {
        QueryWrapper<UmsAdmin> wrapper = new QueryWrapper<>();
        wrapper.and(i -> {
            i.eq("email", text).or().eq("phone", text);
        });
        if (null != id) {
            wrapper.ne("id", id);
        }
        return count(wrapper);
    }
}
