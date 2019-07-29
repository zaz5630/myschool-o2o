package com.iweb.o2o.shop;

import com.iweb.o2o.dto.ShopExecution;
import com.iweb.o2o.entity.Area;
import com.iweb.o2o.entity.Shop;
import com.iweb.o2o.entity.ShopCategory;
import com.iweb.o2o.enums.ShopStateEnum;
import com.iweb.o2o.service.ShopService;
import com.iweb.o2o.shop.ShopApp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.Date;

import static org.junit.Assert.assertEquals;


/**
 * @author azzhu
 * @create 2019-07-17 21:14:09
 */
@SpringBootTest(classes = ShopApp.class)
@RunWith(SpringRunner.class)
public class TestShopService {

    @Autowired
    private ShopService shopService;

    @Test
  public void testAddShop() throws Exception {
    Shop shop = new Shop();
    shop.setOwnerId(8L);
    Area area = new Area();
    area.setAreaId(3L);
    ShopCategory sc = new ShopCategory();
    sc.setShopCategoryId(14L);
    shop.setShopName("mytest111111");
    shop.setShopDesc("mytest1");
    shop.setShopAddr("testaddr1");
    shop.setPhone("13810524526");
    shop.setShopImg("test1");
    shop.setLongitude(1D);
    shop.setLatitude(1D);
    shop.setCreateTime(new Date());
    shop.setLastEditTime(new Date());
    shop.setEnableStatus(ShopStateEnum.CHECK.getState());
    shop.setAdvice("审核中");
    shop.setArea(area);
    shop.setShopCategory(sc);
    //注意：watermark.jpg放在当前测试包的resources下
    File shopImg = new File("D:\\IDEA\\myschool-o2o\\o2o-shop\\src\\test\\resources\\xiaohuangren.jpg");
    ShopExecution se = shopService.addShop(shop,shopImg);
    assertEquals(ShopStateEnum.CHECK.getState(), se.getState());
  }
}
 
 
