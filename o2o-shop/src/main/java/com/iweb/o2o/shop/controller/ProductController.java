package com.iweb.o2o.shop.controller;

import com.iweb.o2o.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @author azzhu
 * @create 2019-07-20 15:19:39
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/list.html")
    public ModelAndView getProductList() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("product.html");
        return mv;
    }

    @GetMapping("/list.json")
    @ResponseBody
    public Object getProducts(@RequestParam("page") Integer page,@RequestParam("limit") Integer limit) {
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","ok");
        map.put("count",productService.getProducts(page,limit,null).getPages());
        map.put("data",productService.getProducts(page,limit,null).getList());
        return map;
    }
}
