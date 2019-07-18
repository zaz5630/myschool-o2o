package com.iweb.o2o.superadmin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author azzhu
 * @create 2019-07-18 14:02:10
 */
@SpringBootApplication
@MapperScan("com.iweb.o2o.mapper") //扫描注解@Mapper
@ComponentScan({"com.iweb.o2o.service","com.iweb.o2o.superadmin.controller"})
public class SuperAdminApp {
    public static void main(String[] args) {
        SpringApplication.run(SuperAdminApp.class);
    }
}
