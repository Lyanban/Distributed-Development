package com.lyanba;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lyanba.entry.UmsAdmin;
import com.lyanba.service.UmsAdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @className: TestClass
 * @description:
 * @author: LyanbA
 * @since: 2021/10/9 18:08
 * @todo:
 */
@SpringBootTest
public class AppTest {
    @Autowired
    UmsAdminService umsAdminService;

    @Test
    void testSave() {
        UmsAdmin umsAdmin = new UmsAdmin();
        umsAdmin.setName("Lyanba").setEmail("lyanba@lyanba.com").setPhone("17733645766").setImage("20210812200149332169615.jpeg");
        umsAdminService.save(umsAdmin);
    }

    @Test
    void testMultiSave() {
        List<UmsAdmin> umsAdminList = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            UmsAdmin umsAdmin = new UmsAdmin();
            umsAdmin.setName("Lyanba" + i).setEmail("lyanba" + i + "@lyanba.com").setPhone("1773364-" + i).setImage("202108122001493321696-" + i + ".jpeg");
            umsAdminList.add(umsAdmin);
        }
        umsAdminService.saveBatch(umsAdminList);
    }

    @Test
    void testUpdate() {
        UmsAdmin umsAdmin = new UmsAdmin();
        umsAdmin.setName("Banban").setEmail("banban@lyanba.com").setPhone("17733645765").setImage("20210812200149332169616.jpeg");
        umsAdmin.setId(2L);
        umsAdminService.updateById(umsAdmin);
    }

    @Test
    void testQuery() {
        List<UmsAdmin> umsAdminList = umsAdminService.list();
        umsAdminList.forEach(System.out::println);
    }

    @Test
    void testConditionQuery() {
        QueryWrapper<UmsAdmin> wrapper = new QueryWrapper<>();
        wrapper.like("name", "7");
        List<UmsAdmin> umsAdminList = umsAdminService.list(wrapper);
        umsAdminList.forEach(System.out::println);
    }
}
