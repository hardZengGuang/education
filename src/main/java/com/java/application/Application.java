package com.java.application;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication(scanBasePackages = "com.java.*")
/*@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})*/
@ServletComponentScan(basePackages = "com.java.*")//过滤器
//@EnableScheduling//定时器
//开启mybatis的注解扫描
@MapperScan("com.java.mapper")//com.java.mapper
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
