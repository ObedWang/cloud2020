package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author : wangebie
 * @date : 2021/1/12 15:35
 */
@SpringBootApplication
@EnableDiscoveryClient
public class KafkaProvider8801 {
    public static void main(String[] args) {
        SpringApplication.run(KafkaProvider8801.class,args);
    }
}
