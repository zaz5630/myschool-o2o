package com.iweb.o2o.service.impl;

import com.iweb.o2o.entity.ShopCategory;
import com.iweb.o2o.mapper.ShopCategoryMapper;
import com.iweb.o2o.service.ShopCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author azzhu
 * @create 2019-07-20 09:39:59
 */
@Service
public class ShopCategoryServiceImpl implements ShopCategoryService {

    @Autowired
    private ShopCategoryMapper shopCategoryMapper;
    @Override
    public List<ShopCategory> getCategories(Long parentId) {
        return shopCategoryMapper.getCategories(parentId);
    }
}
