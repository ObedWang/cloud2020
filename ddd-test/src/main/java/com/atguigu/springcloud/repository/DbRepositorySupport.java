package com.atguigu.springcloud.repository;

import lombok.AccessLevel;
import lombok.Getter;

/**
 * @author : wangebie
 * @date : 2021/2/2 11:17
 */
public abstract class DbRepositorySupport<T extends Aggregate<ID>, ID extends Identifier> implements Repository<T, ID> {
    @Getter
    private final Class<T> targetClass;
    @Getter(AccessLevel.PROTECTED)
    private AggregateManager<T,ID> aggregateManager;

    protected DbRepositorySupport(Class<T> targetClass) {
        this.targetClass = targetClass;
        this.aggregateManager = AggregateManager.newInstance(targetClass);
    }

    /**
     * 需要子类去实现
     * @param aggregate 聚合根
     */
    protected abstract void onInsert(T aggregate);
    protected abstract T onSelect(ID id);
    protected abstract void onUpdate(T aggregate,EntityDiff diff);
    protected abstract void onDelete(T aggregate);


}
