package com.lyanba.entry;

import com.lyanba.entry.BaseEntry;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author LyanbA
 * @since 2021-10-09
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class UmsAdmin extends BaseEntry {
    private static final long serialVersionUID = 1L;

    private String name;

    private String email;

    private String password;

    private String phone;

    private String image;

    private Integer active;
}
