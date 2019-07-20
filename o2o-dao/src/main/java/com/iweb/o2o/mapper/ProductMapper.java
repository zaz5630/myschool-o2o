package com.iweb.o2o.mapper;

import com.iweb.o2o.entity.Product;

import java.util.List;

/**
 * @author azzhu
 * @create 2019-07-20 15:35:58
 */
public interface ProductMapper {
    /**
     * 查询商品
     * @param product
     * @return
     */
    List<Product> getProducts(Product product);
}
