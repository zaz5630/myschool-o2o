package com.iweb.o2o.shop;

import com.iweb.o2o.mapper.ShopCategoryMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author azzhu
 * @create 2019-07-20 09:35:55
 */
@SpringBootTest(classes = ShopApp.class)
@RunWith(SpringRunner.class)
public class ShopCategoryTest {

    @Autowired
    private ShopCategoryMapper shopCategoryMapper;

    @Test
    public void testGetCategory() {
        System.out.println(shopCategoryMapper.getCategories(10L).size());
    }
}
