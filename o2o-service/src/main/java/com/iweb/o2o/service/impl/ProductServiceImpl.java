package com.iweb.o2o.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iweb.o2o.entity.Product;
import com.iweb.o2o.mapper.ProductMapper;
import com.iweb.o2o.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author azzhu
 * @create 2019-07-20 15:38:20
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Override
    public PageInfo getProducts(Integer page,Integer limit,Product product) {
        PageHelper.offsetPage(page,limit);
        List<Product> products = productMapper.getProducts(product);
        return new PageInfo(products);
    }
}
