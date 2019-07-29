package com.iweb.o2o.service;

import com.iweb.o2o.dto.ShopExecution;
import com.iweb.o2o.entity.Shop;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;

/**
 * @author azzhu
 * @create 2019-07-17 20:55:54
 */
public interface ShopService {
    /**
     * 创建商铺
     *
     * @param Shop  shop
     * @return ShopExecution shopExecution
     * @throws Exception
     */
    ShopExecution addShop(Shop shop, File shopImg) throws RuntimeException;

}
 
 
