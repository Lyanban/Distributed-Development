package com.lyanba.entry;

import com.lyanba.entry.BaseEntry;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author LyanbA
 * @since 2021-10-12
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class PmsFile extends BaseEntry {
    private static final long serialVersionUID = 1L;

    private String md5;

    private Long size;

    private String suffix;

    private String path;
}
