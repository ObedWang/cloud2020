package com.atguigu.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author : wangebie
 * @date : 2021/1/7 15:30
 */
@ConfigurationProperties(prefix = "data.json")
public class MyJsonProperties {
    public static final String DEFAULT_NAME = "Obed";
    public String name = DEFAULT_NAME;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
