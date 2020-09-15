package com;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.io.File;
import java.io.IOException;

// 演示例子，执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
public class CodeGenerator {
    //项目路径
    private static String canonicalPath = "";
    //基本包名
    private static String basePackage = "com.whj.demo";
    //作者
    private static String authorName = "whj";
    //要生成的表名，逗号隔开
    private static String tableList = "sh_device_key";
    //表名前缀，用于生成的类名去掉前缀
    private static final String tablePrefix = "sh_";
    //数据库配置四要素
    private static DbType dbType = DbType.MYSQL;
    private static String driverName = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://192.168.0.108:3306/smart-home?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC";
    private static String username = "root";
    private static String password = "123456";


    /**
     * 获取项目路径
     */
    static {
        try {
            canonicalPath = new File("").getCanonicalPath();
            System.out.println("项目绝对路径:" + canonicalPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig()
                .setOutputDir(canonicalPath + "/src/main/java")
                .setOpen(false)
                .setFileOverride(true)
                .setFileOverride(true)
                .setAuthor(authorName);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig()
                .setUrl(url)
                .setDbType(dbType)
                .setDriverName(driverName)
                .setUsername(username)
                .setPassword(password)
//                .setSchemaName("public")
                ;
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig()
                .setParent(basePackage)
                .setXml("xml");
        mpg.setPackageInfo(pc);

        //指定自定义模板路径, 位置：/resources/templates/entity2.java.ftl(或者是.vm)
        //注意不要带上.ftl(或者是.vm), 会根据使用的模板引擎自动识别
        TemplateConfig templateConfig = new TemplateConfig().setMapper("templates/mapper2.java");
        //配置自定义模板
        mpg.setTemplate(templateConfig);

        // 策略配置
        String[] tables = tableList.split(",");
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setControllerMappingHyphenStyle(false);
        strategy.setInclude(tables);
        strategy.setTablePrefix(tablePrefix);
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

}