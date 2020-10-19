package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author ：web
 * @date ：0:51 2020/10/20
 */
public interface LoadBalance {
    /**
     * list
     * @param list list
     * @return obj
     */
    ServiceInstance instance(List<ServiceInstance> list);
}
