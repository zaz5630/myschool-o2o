package com.iweb.o2o.mapper;

import com.iweb.o2o.entity.Area;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author azzhu
 * @create 2019-07-18 13:35:32
 */
@Mapper
public interface AreaMapper {

    /**
     * 获取所有地区
     * @return
     */
    List<Area> getAllAreas();
}
