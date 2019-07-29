package com.iweb.o2o.service;

import com.github.pagehelper.PageInfo;
import com.iweb.o2o.entity.Product;

import java.util.List;

/**
 * @author azzhu
 * @create 2019-07-20 15:37:44
 */
public interface ProductService {

    /**
     * 查询商品
     * @param product
     * @return
     */
    PageInfo getProducts(Integer page,Integer limit,Product product);
}
