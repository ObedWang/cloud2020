package com.atguigu.springcloud.alibaba.service;

/**
 * @author : wangebie
 * @date : 2021/2/9 13:42
 */
public interface StorageService {
    /**
     * 扣减库存
     *
     * @param productId productId
     * @param count     count
     */
    void decrease(Long productId, Integer count);
}
