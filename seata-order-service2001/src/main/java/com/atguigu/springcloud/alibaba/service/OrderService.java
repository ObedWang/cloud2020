package com.atguigu.springcloud.alibaba.service;

import com.atguigu.springcloud.alibaba.domain.Order;

/**
 * @author : wangebie
 * @date : 2021/2/9 9:59
 */
public interface OrderService {
    /**
     * create order
     * @param order order
     */
    void create(Order order);
}
