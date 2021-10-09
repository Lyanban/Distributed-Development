package com.lyanba.entry;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @className: BaseEntry
 * @description:
 * @author: LyanbA
 * @since: 2021/10/9 17:51
 * @todo:
 */
@Data
public class BaseEntry {
    @TableId(type = IdType.AUTO)
    private Long id;
}
