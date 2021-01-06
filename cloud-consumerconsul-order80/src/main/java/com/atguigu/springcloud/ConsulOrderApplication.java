package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author : wangeb
 * @date : 2020/10/19 10:01
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsulOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsulOrderApplication.class,args);
    }
}
