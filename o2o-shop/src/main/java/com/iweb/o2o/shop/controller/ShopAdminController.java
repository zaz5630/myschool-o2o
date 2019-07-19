package com.iweb.o2o.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author azzhu
 * @create 2019-07-19 15:37:15
 */
@Controller
@RequestMapping("/shop")
public class ShopAdminController {

    @GetMapping("/add.html")
    public String toAdd() {
        return "add.html";
    }
}
