package com.atguigu.springcloud.lib;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Author theone
 * @Date 2020/4/28 22:41
 * @Version 1.0
 */
public interface LoadBalancer {

    ServiceInstance instances(List<ServiceInstance> serviceInstances);

}
