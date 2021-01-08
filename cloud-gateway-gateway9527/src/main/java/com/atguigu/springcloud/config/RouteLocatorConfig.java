package com.atguigu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author : wangebie
 * @date : 2021/1/8 14:34
 */
@Configuration
public class RouteLocatorConfig {
//    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("guonei", r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
        routes.route("game", predicateSpec -> predicateSpec.path("/game")
                .filters(gatewayFilterSpec -> gatewayFilterSpec.addRequestHeader("token", "testToken").addResponseHeader("123", "456"))
                .uri("http://news.baidu.com/game"));
        routes.route("hystrix", predicateSpec -> predicateSpec
                .host("*.hystrix.com")
                .filters(f -> f.hystrix(config -> config.setName("mycmd").setFallbackUri("forward:/fallback")))
                .uri("http://httpbin.org:80"));
        routes.route("test", predicateSpec ->
                predicateSpec.path("/payment/get/**").and().after(ZonedDateTime.of(2021, 12, 31, 0, 0, 0, 0, ZoneId.systemDefault()))
                        .uri("http://localhost:8001")
        );

        return routes.build();
    }

}
