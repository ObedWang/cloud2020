package com.atguigu.springcloud.lb;


import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ：web
 * @date ：0:55 2020/10/20
 */
@Component
public class MyLB implements LoadBalance {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    private int compareAndSet() {
        int cur, next;
        do {
            cur = atomicInteger.get();
            next = cur >= Integer.MAX_VALUE ? 0 : cur + 1;

        } while (!atomicInteger.compareAndSet(cur, next));
        return next;
    }

    @Override
    public final ServiceInstance instance(List<ServiceInstance> list) {
        if (list == null || list.size() <= 0) return null;
        int index = compareAndSet() % list.size();
        return list.get(index);
    }
}
