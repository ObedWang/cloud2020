package com.atguigu.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : wangebie
 * @date : 2020/12/30 17:48
 */
@RestController
@RefreshScope
public class HelloController {

    @Value("${author}")
    private String author;

    @GetMapping("/api/hello")
    public Object hello() {
        return "hello" + author;
    }

}
