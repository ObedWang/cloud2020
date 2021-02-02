package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * @author : wangebie
 * @date : 2021/1/13 13:49
 */
@RestController
public class PaymentController
{
    @Value("${server.port}")
    private String serverPort;
    @Value("${spring.cloud.nacos.discovery.server-addr}")
    private String nacosString;


    @GetMapping(value = "/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id)
    {
        return "nacos registry, serverPort: "+ serverPort+"\t id"+id;
    }



    @PostConstruct
    public void doSomething(){
        System.out.println(nacosString);
    }
}

