package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author ：web
 * @date ：23:53 2020/10/18
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ZkOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZkOrderApplication.class,args);
    }
}
