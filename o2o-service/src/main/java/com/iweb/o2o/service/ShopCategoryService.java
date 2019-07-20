package com.iweb.o2o.service;

import com.iweb.o2o.entity.ShopCategory;

import java.util.List;

/**
 * @author azzhu
 * @create 2019-07-20 09:39:06
 */
public interface ShopCategoryService {

    /**
     * 查询店铺分类id
     * @param parentId
     * @return
     */
    List<ShopCategory> getCategories(Long parentId);
}
