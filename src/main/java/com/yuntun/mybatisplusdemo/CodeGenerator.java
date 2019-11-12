package com.yuntun.mybatisplusdemo;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

// 演示例子，执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
public class CodeGenerator {
    //项目路径
    private static String canonicalPath = "";
    //基本包名
    private static String basePackage = "com.yuntun.mybatisplusdemo";
//    private static String moduleName = "mybatisplusdemo";
    //作者
    private static String authorName = "whj";
    //要生成的表名
    private static String[] tables = {"package_fee_copy"};
    //数据库配置四要素
    private static DbType dbType = DbType.SQL_SERVER;
    private static String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String url = "jdbc:sqlserver://47.92.171.81:1433;databaseName=yanglao-yuntun";
    private static String username = "sa";
    private static String password = "yanglao~!@123";

    private final static Logger logger = LoggerFactory.getLogger(CodeGenerator.class);

    /**
     * 获取项目路径
     */
   static{
        try {
            canonicalPath = new File("").getCanonicalPath();
            logger.info("项目绝对路径:{}",canonicalPath);
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
                .setAuthor(authorName)
                ;
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig()
                .setUrl(url)
                .setDbType(dbType)
                .setDriverName(driverName)
                .setUsername(username)
                .setPassword(password)
                //.setSchemaName("public")
                ;
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig().setParent(basePackage);
        mpg.setPackageInfo(pc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setControllerMappingHyphenStyle(false);
        strategy.setInclude(tables);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

}