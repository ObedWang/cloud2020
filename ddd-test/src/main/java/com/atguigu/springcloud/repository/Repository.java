package com.atguigu.springcloud.repository;

/**
 * @author : wangebie
 * @date : 2021/2/2 11:21
 */
public interface Repository<T extends Aggregate<ID>, ID extends Identifier> {
    /**
     * 将一个聚合附属到一个repo上，让他变为可追踪
     *
     * @param aggregate 聚合根
     */
    void attach(T aggregate);

    /**
     * 接触对一个聚合的追踪
     *
     * @param aggregate 聚合
     */
    void detach(T aggregate);

    /**
     * find entity by id
     *
     * @param id id
     * @return entity
     */
    T find(ID id);

    /**
     * 删除
     *
     * @param aggregate 聚合根
     */
    void remove(T aggregate);

    /**
     * 保存
     *
     * @param aggregate 聚合根
     */
    void save(T aggregate);
}
