package com.dewi.consulconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: guoyuting
 * @Date: Created at 2020/5/10 2:03 PM
 */
@RestController
public class CallHelloController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping(value = "/call")
    public String callHello() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("consul-producer");
        System.out.println("服务地址：" + serviceInstance.getUri());
        System.out.println("服务名称: " + serviceInstance.getServiceId());

        String callResult = new RestTemplate().getForObject(serviceInstance.getUri().toString() + "/hello", String.class);
        System.out.println(callResult);
        return callResult;

    }

}
