package com.atguigu.springcloud.alibaba.dao;

import com.atguigu.springcloud.alibaba.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author : wangebie
 * @date : 2021/2/9 9:55
 */
@Mapper
public interface OrderDao {
    /**
     * create order
     *
     * @param order order
     */
    void create(Order order);

    /**
     * update status
     *
     * @param userId user id
     * @param status status
     */
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
