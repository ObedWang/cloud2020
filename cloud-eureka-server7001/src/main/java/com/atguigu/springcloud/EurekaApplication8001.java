package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author ：web
 * @date ：17:08 2020/10/17
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication8001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication8001.class,args);
    }
}
