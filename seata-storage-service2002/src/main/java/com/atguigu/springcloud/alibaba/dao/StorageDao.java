package com.atguigu.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author : wangebie
 * @date : 2021/2/9 13:41
 */
@Mapper
public interface StorageDao {


    /**
     * 扣减库存信息
     *
     * @param productId productId
     * @param count     count
     */
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
