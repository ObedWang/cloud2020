package com.atguigu.springcloud.repository;

/**
 * @author : wangebie
 * @date : 2021/2/2 11:26
 */
public interface Identifiable<ID extends Identifier> {
    /**
     * 获取id
     *
     * @return identifier
     */
    ID getId();
}
