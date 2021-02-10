package com.atguigu.springcloud.repository;

/**
 * @author : wangebie
 * @date : 2021/2/3 13:38
 */
public class AggregateManager<T extends Aggregate<ID>, ID extends Identifier> {

    public static AggregateManager newInstance(Class targetClass){
        return new AggregateManager<>();
    }
}
