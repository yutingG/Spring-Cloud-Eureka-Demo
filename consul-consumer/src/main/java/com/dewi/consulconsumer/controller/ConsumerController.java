package com.dewi.consulconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: guoyuting
 * @Date: Created at 2020/5/10 1:57 PM
 */
@RestController
public class ConsumerController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * 根据service-id获取所有服务
     * @return
     */
    @GetMapping(value = "/services")
    public Object services() {
        return discoveryClient.getInstances("consul-producer");
    }

    /**
     * 从所有服务中，轮询获取一个服务
     * @return
     */
    @GetMapping(value = "/discover")
    public Object discover() {
        return loadBalancerClient.choose("consul-producer").getUri().toString();
    }


}
