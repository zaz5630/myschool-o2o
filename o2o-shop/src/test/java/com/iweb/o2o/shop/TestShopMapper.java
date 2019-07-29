package com.iweb.o2o.shop;

import com.iweb.o2o.entity.Area;
import com.iweb.o2o.entity.Shop;
import com.iweb.o2o.entity.ShopCategory;
import com.iweb.o2o.mapper.ShopMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * @author azzhu
 * @create 2019-07-17 19:27:47
 */
// 获取启动类，加载配置，确定装载 Spring 程序的装载方法，它回去寻找 主配置启动类（被 @SpringBootApplication 注解的）
@SpringBootTest(classes = ShopApp.class)
// 让 JUnit 运行 Spring 的测试环境， 获得 Spring 环境的上下文的支持
@RunWith(SpringRunner.class)
public class TestShopMapper {
    @Autowired
    private ShopMapper shopMapper;

    @Test
    public void testAInsertShop() throws Exception {
        Shop shop = new Shop();
        shop.setOwnerId(8L);
        Area area = new Area();
        area.setAreaId(3L);
        ShopCategory sc = new ShopCategory();
        sc.setShopCategoryId(14L);
        shop.setShopName("mytest1");
        shop.setShopDesc("mytest1");
        shop.setShopAddr("testaddr1");
        shop.setPhone("13810524526");
        shop.setShopImg("test1");
        shop.setLongitude(1D);
        shop.setLatitude(1D);
        shop.setCreateTime(new Date());
        shop.setLastEditTime(new Date());
        shop.setEnableStatus(0);
        shop.setAdvice("审核中");
        shop.setArea(area);
        shop.setShopCategory(sc);
        int effectedNum = shopMapper.insertShop(shop);
        assertEquals(1, effectedNum);
    }

    @Test
    public void testUpdateShop() {
        Shop shop = new Shop();
        shop.setOwnerId(8L);
        shop.setShopDesc("mytest1");
        shop.setShopAddr("南京徐庄软件园");
        shop.setShopId(37L);
        shop.setShopName("哈哈fdfdfdf");
        shop.setEnableStatus(0);
        int effectedNum = shopMapper.updateShop(shop);
        assertEquals(1, effectedNum);
    }
}
