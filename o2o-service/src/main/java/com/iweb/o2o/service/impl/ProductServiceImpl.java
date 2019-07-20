package com.iweb.o2o.service.impl;

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
    public List<Product> getProducts(Product product) {
        return productMapper.getProducts(product);
    }
}
