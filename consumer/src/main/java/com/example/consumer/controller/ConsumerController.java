package com.example.consumer.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConsumerController {

    // 注入服务提供者。
    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/instances")
    public List<ServiceInstance> getInstances() {
        List<ServiceInstance> providers = discoveryClient.getInstances("provider");
        return providers;
    }
}
