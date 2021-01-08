package com.atguigu.service;

import com.alibaba.fastjson.JSON;

/**
 * @author : wangebie
 * @date : 2021/1/7 15:09
 */
public class MyJsonService {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String objToJson(Object object) {
        return getName() + JSON.toJSONString(object);
    }
}
