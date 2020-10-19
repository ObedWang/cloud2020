package com.atguigu.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：web
 * @date ：22:56 2020/10/19
 */
@Configuration
public class RibbonRuleConfig {
    @Bean
    public IRule myRule(){
        return new RandomRule();
    }
}
