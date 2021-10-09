package com.lyanba;

import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.lyanba.entry.BaseEntry;

import java.util.HashMap;
import java.util.Map;

/**
 * @className: CodeGenerator
 * @description: 代码生成器
 * @author: LyanbA
 * @since: 2021/10/9 17:28
 * @todo:
 */
public class CodeGenerator {
    public static void main(String[] args) {
        // 创建代码生成器对象
        AutoGenerator mpg = new AutoGenerator();
        // 创建全局配置对象
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath);
        gc.setAuthor("LyanbA");
        gc.setOpen(false);
        gc.setFileOverride(false);
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        mpg.setGlobalConfig(gc);
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://192.168.0.110:3308/docker" +
                "?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true&characterEncoding=utf8");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        mpg.setDataSource(dsc);
        // 设置entry路径
        String entryPath = projectPath + "/entry/src/main/java/com/lyanba/entry";
        // 设置其他模块路径
        String otherModule = "admin";
        String otherPath = projectPath + "/" + otherModule + "/src/main";
        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.lyanba");
        pc.setEntity("entry");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setController("controller");
        Map<String, String> pathInfo = new HashMap<>();
        // 设置生成路径
        pathInfo.put("entity_path", entryPath);
        pathInfo.put("mapper_path", otherPath + "/java/com/lyanba/mapper");
        pathInfo.put("xml_path", otherPath + "/resources/com/lyanba/mapper");
        pathInfo.put("service_path", otherPath + "/java/com/lyanba/service");
        pathInfo.put("service_impl_path", otherPath + "/java/com/lyanba/service/impl");
        pathInfo.put("controller_path", otherPath + "/java/com/lyanba/controller");
        pc.setPathInfo(pathInfo);
        mpg.setPackageInfo(pc);
        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setSuperEntityClass(BaseEntry.class);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        // 公共父类
        // strategy.setSuperControllerClass("你自己的父类控制器,没有就不用设置!");
        // 父类中的公共字段
        strategy.setSuperEntityColumns("id");
        // 要生成的表名
        strategy.setInclude("ums_admin");
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        // mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        // 执行代码生成
        mpg.execute();
    }
}
