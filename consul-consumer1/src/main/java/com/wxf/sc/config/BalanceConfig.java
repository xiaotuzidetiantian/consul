package com.wxf.sc.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BalanceConfig {
    @Bean
    public IRule myRult() {
        //指定使用随机的负载均衡算法
//        return new RandomRule();
        return new RoundRobinRule();
    }
}
