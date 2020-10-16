package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author ：web
 * @date ：22:06 2020/10/15
 */
@Mapper
public interface PaymentDao {
    /**
     * create
     *
     * @param payment entity
     * @return is success
     */
    int create(Payment payment);

    /**
     * get entity
     *
     * @param id id
     * @return entity
     */
    Payment getPaymentById(@Param("id") Long id);
}
