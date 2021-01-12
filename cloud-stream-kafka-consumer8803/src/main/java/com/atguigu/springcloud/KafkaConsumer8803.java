package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author : wangebie
 * @date : 2021/1/12 16:06
 */
@SpringBootApplication
@EnableDiscoveryClient
public class KafkaConsumer8803 {
    public static void main(String[] args) {
        SpringApplication.run(KafkaConsumer8803.class,args);
    }
}
