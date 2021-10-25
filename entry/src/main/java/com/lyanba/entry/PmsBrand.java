package com.lyanba.entry;

import com.lyanba.entry.BaseEntry;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 品牌表
 * </p>
 *
 * @author LyanbA
 * @since 2021-10-14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class PmsBrand extends BaseEntry {
    private static final long serialVersionUID = 1L;

    /**
     * 品牌名
     */
    private String name;

    /**
     * 品牌名首字母
     */
    private String firstLetter;

    /**
     * 品牌名Logo
     */
    private String logo;

    /**
     * 品牌名说明
     */
    private String description;

    /**
     * 是否有效
     */
    private Integer active;
}
