package com.atguigu.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import feign.Feign;
import org.springframework.stereotype.Component;

/**
 * @author ：web
 * @date ：23:40 2020/10/22
 */
@Component
@DefaultProperties(defaultFallback = "defaultMethod")
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_OK , (┬＿┬)";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_TimeOut , (┬＿┬)";
    }

    public String defaultMethod(){
        return "default_Method";
    }
}
