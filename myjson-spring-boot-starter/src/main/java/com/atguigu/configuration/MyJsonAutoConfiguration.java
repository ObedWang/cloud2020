package com.atguigu.configuration;

import com.atguigu.properties.MyJsonProperties;
import com.atguigu.service.MyJsonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自己手写一个spring-boot-starter
 * 1.新建一个AutoConfiguration类，该类里面有你需要注入的bean（注意该类上面的注解）
 * 2.resources下面新建一个META-INF里面spring.factories
 * 3.mvn install
 *
 * @author : wangebie
 * @date : 2021/1/7 15:32
 */
@Configuration
@ConditionalOnProperty(value = "data.json.enable", matchIfMissing = false, havingValue = "true")
@EnableConfigurationProperties(MyJsonProperties.class)
public class MyJsonAutoConfiguration {

    @Autowired
    private MyJsonProperties myJsonProperties;

    @Bean
    @ConditionalOnMissingBean(MyJsonService.class)
    public MyJsonService myJsonService() {
        System.out.println("开始加载MyJsonService，贼强！！！");
        MyJsonService myJsonService = new MyJsonService();
        myJsonService.setName(myJsonProperties.getName());
        return myJsonService;
    }
}
