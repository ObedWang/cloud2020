package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author : wangeb
 * @date : 2020/10/20 19:55
 */
@SpringBootApplication
@EnableFeignClients
public class FeignOrderApplication80 {
    public static void main(String[] args) {
        SpringApplication.run(FeignOrderApplication80.class,args);
    }
}
