package com.atguigu.springcloud;

import com.atguigu.springcloud.config.RibbonRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * @author ：web
 * @date ：21:26 2020/10/16
 */
@SpringBootApplication
@EnableEurekaClient
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {RibbonRuleConfig.class}))
@RibbonClients(value = {@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = RibbonRuleConfig.class)})
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}
