package com.atguigu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author : wangebie
 * @date : 2021/1/7 15:43
 */
@SpringBootApplication
@EnableDiscoveryClient
public class StarterUserExampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(StarterUserExampleApplication.class,args);
    }
}
