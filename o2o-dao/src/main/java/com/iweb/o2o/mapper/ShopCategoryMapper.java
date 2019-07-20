package com.iweb.o2o.mapper;

import com.iweb.o2o.entity.ShopCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author azzhu
 * @create 2019-07-20 09:23:32
 */
public interface ShopCategoryMapper {

    /**
     * 一级分类，实际上这个方法不需要的
     * @return
     */
    @Deprecated
    public List<ShopCategory> getOneCategories();

    /**
     * 二级分类
     * @param parentId
     * @return
     */
    public List<ShopCategory> getCategories(@Param("parentId") Long parentId);
}
