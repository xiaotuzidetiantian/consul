package com.wxf.sc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class TestProvider {
    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @RequestMapping("services")
    public List<String> getServices() {
        List<String> services = discoveryClient.getServices();
        return services;
    }

    @RequestMapping("getService")
    public List<ServiceInstance> getService() {
        List<ServiceInstance> provider = discoveryClient.getInstances("provider");
        return provider;
    }

    @RequestMapping("balanceCall")
    public String balanceCall() {
        ServiceInstance instance = loadBalancerClient.choose("providerName");
        String url = instance.getUri().toString()+"/test";
        RestTemplate restTemplate = new RestTemplate();
        String s = restTemplate.getForObject(url, String.class);
        System.out.println("return is "+s);
        return s;
    }

    @RequestMapping("callService")
    public String callService() {
        List<ServiceInstance> provider2 = discoveryClient.getInstances("provider");
        if(provider2!=null && provider2.size()>0) {
            ServiceInstance serviceInstance = provider2.get(0);
            RestTemplate restTemplate = new RestTemplate();
            String result = restTemplate.getForObject(serviceInstance.getUri().toString()+"test",String.class);
            return result;
        }
        return "no service...";
    }

}
