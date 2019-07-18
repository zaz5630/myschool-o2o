package com.iweb.o2o.superadmin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author azzhu
 * @create 2019-07-18 14:02:10
 */
@SpringBootApplication
@MapperScan("com.iweb.o2o.mapper")
public class SuperAdminApp {
    public static void main(String[] args) {
        SpringApplication.run(SuperAdminApp.class);
    }
}
