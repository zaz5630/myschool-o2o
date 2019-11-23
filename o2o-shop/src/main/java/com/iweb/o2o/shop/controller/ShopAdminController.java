package com.iweb.o2o.shop.controller;

import com.iweb.o2o.entity.ShopCategory;
import com.iweb.o2o.service.AreaService;
import com.iweb.o2o.service.ShopCategoryService;
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
 * @create 2019-07-19 15:37:15
 */
@Controller
@RequestMapping("/shop")
public class ShopAdminController {

    @Autowired
    private AreaService areaService;

    @Autowired
    private ShopCategoryService shopCategoryService;

    @GetMapping("/add.html")
    public ModelAndView toAdd() {
        //应该查询出地区列表放入到域中
        ModelAndView mv = new ModelAndView();
        mv.addObject("ares",areaService.getAllAreas());
        mv.setViewName("add.html");
        return mv;
    }

    @GetMapping("/shopedit.html")
    public ModelAndView toRegister() {
        //应该查询出地区列表放入到域中
        ModelAndView mv = new ModelAndView();
        mv.addObject("ares",areaService.getAllAreas());
        mv.setViewName("shopedit.html");
        return mv;
    }



    @GetMapping("/categories")
    @ResponseBody
    public Object getCategories(@RequestParam(required = false,name = "parentId") Long parentId) {
        return shopCategoryService.getCategories(parentId);
    }

}
