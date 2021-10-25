package com.lyanba.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lyanba.entry.PmsBrand;
import com.lyanba.entry.ResultJson;
import com.lyanba.service.FileService;
import com.lyanba.service.PmsBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 品牌表 前端控制器
 * </p>
 *
 * @author LyanbA
 * @since 2021-10-14
 */
@RestController
@RequestMapping("/pms-brand")
public class PmsBrandController {
    @Autowired
    PmsBrandService pmsBrandService;

    @Autowired
    FileService fileService;

    @GetMapping("/list")
    ResultJson<Page<PmsBrand>> list(int pageNo, int pageSize, String search) {
        return ResultJson.success(pmsBrandService.list(pageNo, pageSize, search));
    }

    @PostMapping("/save")
    ResultJson<Boolean> saveUmsAdmin(PmsBrand pmsBrand, MultipartFile file) throws Exception {
        pmsBrand.setLogo(fileService.fileUpload(file));
        return ResultJson.success(pmsBrandService.save(pmsBrand), "新增用户成功");
    }

    @GetMapping("/getBrandById")
    ResultJson<PmsBrand> getUmsAdminById(Long id) {
        return ResultJson.success(pmsBrandService.getById(id));
    }

    @PutMapping("/update")
    ResultJson<Boolean> updateUmsAdminById(PmsBrand pmsBrand, MultipartFile file) {
        if (null != file && 0 < file.getSize()) {
            pmsBrand.setLogo(fileService.fileUpload(file));
        }
        return ResultJson.success(pmsBrandService.updateById(pmsBrand), "更新品牌成功");
    }

    @PutMapping("/delete")
    ResultJson<Boolean> deleteUmsAdminById(PmsBrand pmsBrand) {
        return ResultJson.success(pmsBrandService.updateById(pmsBrand), pmsBrand.getActive() == 0 ? "删除品牌成功" : "恢复品牌成功");
    }

    @GetMapping("/check")
    ResultJson<Integer> checkEmailPhone(Long id, String text) {
        return ResultJson.success(pmsBrandService.check(id, text));
    }
}

