package com.iweb.o2o.service.impl;

import com.iweb.o2o.dto.ShopExecution;
import com.iweb.o2o.entity.Shop;
import com.iweb.o2o.entity.ShopCategory;
import com.iweb.o2o.enums.ShopStateEnum;
import com.iweb.o2o.exceptions.ShopOptionException;
import com.iweb.o2o.mapper.ShopMapper;
import com.iweb.o2o.service.ShopService;
import com.iweb.o2o.util.FileUtil;
import com.iweb.o2o.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.util.Date;

/**
 * @author azzhu
 * @create 2019-07-17 20:57:35
 */
@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopMapper shopMapper;

    /**
     * /**
     * 使用注解控制事务方法的优点： 1.开发团队达成一致约定，明确标注事务方法的编程风格
     * 2.保证事务方法的执行时间尽可能短，不要穿插其他网络操作，RPC/HTTP请求或者剥离到事务方法外部
     * 3.不是所有的方法都需要事务，如只有一条修改操作，只读操作不需要事务控制
     */
    @Override
    @Transactional
    public ShopExecution addShop(Shop shop, File shopImg) throws ShopOptionException {
        if (shop == null) {
            return new ShopExecution(ShopStateEnum.NULL_SHOP_INFO);
        }
        try {
            //给店铺信息赋初始值
            shop.setEnableStatus(0);  //未上架，审核中
            shop.setCreateTime(new Date());
            shop.setLastEditTime(new Date());
            if (shop.getShopCategory() != null) {
                Long shopCategoryId = shop.getShopCategory()
                        .getShopCategoryId();
                ShopCategory sc = new ShopCategory();
                //后面再做，暂且写死
                sc.setShopCategoryId(14L);
                // sc = shopCategoryDao.queryShopCategoryById(shopCategoryId);
                ShopCategory parentCategory = new ShopCategory();
                parentCategory.setShopCategoryId(sc.getParentId());
                shop.setParentCategory(parentCategory);
            }
            //添加店铺信息
            int effectedNum = shopMapper.insertShop(shop);
            if (effectedNum <= 0) {
                throw new ShopOptionException("店铺创建失败");
            } else {
                try {
                    if (shopImg != null) {
                        //存储图片
                        addShopImg(shop, shopImg);
                        //更新店铺的图片地址
                        effectedNum = shopMapper.updateShop(shop);
                        if (effectedNum <= 0) {
                            //此处最好使用自定义异常
                            throw new ShopOptionException("创建图片地址失败");
                        }
                    }
                } catch (Exception e) {
                    throw new ShopOptionException("addShopImg error: "
                            + e.getMessage());
                }
            }
        } catch (Exception e) {
            throw new ShopOptionException("insertShop error: " + e.getMessage());
        }
        return new ShopExecution(ShopStateEnum.CHECK, shop);
    }

    private void addShopImg(Shop shop, File shopImg) {
        //获取shop图片的相对路径
        String dest = FileUtil.getShopImagePath(shop.getShopId());
        String shopImgAddr = ImageUtil.generateThumbnail(shopImg, dest);
        shop.setShopImg(shopImgAddr);
    }
}
 
 
