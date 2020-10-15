package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.springframework.stereotype.Service;

/**
 * @author ：web
 * @date ：22:09 2020/10/15
 */

public interface PaymentService {
    /**
     * 写
     *
     * @param payment
     * @return
     */
    int create(Payment payment);

    /**
     * 读取
     *
     * @param id
     * @return
     */
    Payment getPaymentById(Long id);
}

