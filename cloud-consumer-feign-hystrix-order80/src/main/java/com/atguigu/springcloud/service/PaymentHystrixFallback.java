package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author : wangebie
 * @date : 2020/12/29 14:50
 */
@Component
public class PaymentHystrixFallback implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "null";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "调用payment超时~~~ id = "+id;
    }
}
