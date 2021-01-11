package com.atguigu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author : wangebie
 * @date : 2021/1/11 10:36
 */
@SpringBootApplication
@EnableDiscoveryClient

public class ConfigClient9093Application {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClient9093Application.class,args);
    }
}
