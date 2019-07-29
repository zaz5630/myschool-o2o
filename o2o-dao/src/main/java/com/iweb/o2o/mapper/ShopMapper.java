package com.iweb.o2o.mapper;

import com.iweb.o2o.entity.Shop;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author azzhu
 * @create 2019-07-17 19:14:30
 */
public interface ShopMapper {

    /**
     * 新增店铺
     * @param shop
     * @return
     */
    int insertShop(Shop shop);

    /**
     * 更新店铺信息
     *
     * @param shop
     * @return effectedNum
     */
    int updateShop(Shop shop);
}