package com.lyanba.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lyanba.entry.PmsBrand;
import com.lyanba.mapper.PmsBrandMapper;
import com.lyanba.service.PmsBrandService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 品牌表 服务实现类
 * </p>
 *
 * @author LyanbA
 * @since 2021-10-14
 */
@Service
public class PmsBrandServiceImpl extends ServiceImpl<PmsBrandMapper, PmsBrand> implements PmsBrandService {
    @Override
    public Page<PmsBrand> list(int pageNo, int pageSize, String search) {
        QueryWrapper<PmsBrand> wrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(search)) {
            wrapper.like("name", search)
                    .or().like("first_letter", search);
        }
        return page(new Page<>(pageNo, pageSize), wrapper);
    }

    @Override
    public int check(Long id, String text) {
        QueryWrapper<PmsBrand> wrapper = new QueryWrapper<>();
        wrapper.eq("name", text);
        if (null != id) {
            wrapper.ne("id", id);
        }
        return count(wrapper);
    }
}
