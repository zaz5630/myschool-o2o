package com.iweb.o2o.superadmin.controller;

import com.iweb.o2o.entity.Area;
import com.iweb.o2o.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author azzhu
 * @create 2019-07-18 14:14:01
 */
@Controller
@RequestMapping("/admin")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @GetMapping("/test")
    public ModelAndView testArea() {
        ModelAndView mv = new ModelAndView();

        //模型数据
        List<Area> allAreas = areaService.getAllAreas();
        mv.addObject("areas",allAreas);
        //视图
        mv.setViewName("test.html");
        return mv;
    }
}
