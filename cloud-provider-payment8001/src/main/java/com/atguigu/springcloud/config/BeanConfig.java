package com.atguigu.springcloud.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.sleuth.zipkin2.ZipkinProperties;
import org.springframework.cloud.sleuth.zipkin2.ZipkinRestTemplateCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import zipkin2.Call;
import zipkin2.Span;
import zipkin2.codec.BytesEncoder;
import zipkin2.codec.Encoding;
import zipkin2.reporter.Sender;

import java.util.List;

/**
 * @author : wangebie
 * @date : 2021/1/21 17:21
 */
@Configuration
public class BeanConfig {
    @Bean
    public ZipkinRestTemplateCustomizer zipkinRestTemplateCustomizer(){
        return new ZipkinRestTemplateCustomizer() {
        };
    }
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public Sender sender(RestTemplate restTemplate, BytesEncoder<Span> encoder){
        return new MyRestTemplateSender(restTemplate,"http://36.134.58.176:9411",encoder);
    }


}
