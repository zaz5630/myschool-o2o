package com.iweb.o2o.shop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author azzhu
 * @create 2019-07-19 10:33:16
 */
@SpringBootApplication
@MapperScan("com.iweb.o2o.mapper")
@ComponentScan({"com.iweb.o2o.service","com.iweb.o2o.shop.controller"})
public class ShopApp {
    public static void main(String[] args) {
        SpringApplication.run(ShopApp.class,args);
    }
}
