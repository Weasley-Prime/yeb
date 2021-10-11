package com.dong.generator;



import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.querys.MySqlQuery;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.keywords.MySqlKeyWordsHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.Scanner;


public class CodeGenerator {
    public static void main(String[] args) {
        DataSourceConfig dsc = new DataSourceConfig.Builder("jdbc:mysql://192.168.64.128:3306/yeb?useUnicode=true&useSSL=false&characterEncoding=utf-8&encodingTimezone=Asia/Shanghai","root","1422971650")
                .typeConvert(new MySqlTypeConvert())
                .keyWordsHandler(new MySqlKeyWordsHandler())
                .dbQuery(new MySqlQuery())
                .build();
        generate(dsc);
    }


    public static void generate(DataSourceConfig dsc) {

        // 代码生成器
        AutoGenerator mpg = new AutoGenerator(dsc);
        String path = System.getProperty("user.dir")+"/yeb-generator/src/main/java";
        // 全局配置
        mpg.global(getGlobalConfig(path));

        // 包配置
        PackageConfig pc = new PackageConfig.Builder()
        .parent("com.dong.generator")
        .build();
        mpg.packageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig.Builder()
                .beforeOutputFile((table,map)->{
                    map.put("date", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                    map.put("baseUrl","api/v1");
                })
                .build();
        mpg.injection(cfg);
        TemplateConfig templateConfig = new TemplateConfig.Builder().build();
        mpg.template(templateConfig);

        // 策略配置
        String tables = scan("数据库表 (t_user,t_role)");
        StrategyConfig strategy = new StrategyConfig.Builder()
                .addInclude(tables.split(","))
                .entityBuilder()
                .enableLombok()
                .naming(NamingStrategy.underline_to_camel)
                .columnNaming(NamingStrategy.underline_to_camel)
                .idType(IdType.ASSIGN_ID)
                .controllerBuilder()
                .enableRestStyle()
                .enableHyphenStyle()
                .build();
        mpg.strategy(strategy);
        mpg.execute(new FreemarkerTemplateEngine());
    }

    private static GlobalConfig getGlobalConfig(String path) {
        return new GlobalConfig.Builder()
                .outputDir(path)
                .enableSwagger()
                .author(scan("作者"))
                .fileOverride()
                .build();
    }

    private static String scan(String dit){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入" + dit + ":");
        if(scanner.hasNext()){
            String s = scanner.next();
            if(s!=null && s.trim().length() > 0){
                return s;
            }
        }
        throw new MybatisPlusException("请输入正确的"+ dit + "!");
    }


}

