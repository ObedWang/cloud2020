package com.atguigu.controller;

import com.atguigu.service.MyJsonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : wangebie
 * @date : 2021/1/7 15:45
 */
@RestController
public class DemoController {

    @Autowired
    private MyJsonService myJsonService;

    @GetMapping("/demo")
    public String getDemo(){
        return myJsonService.objToJson(new User("哈哈",12));
    }

    public class User{
        private String name;
        private Integer age;

        public User() {
        }

        public User(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }
}
