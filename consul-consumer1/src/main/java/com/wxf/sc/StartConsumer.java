package com.wxf.sc;

import com.wxf.sc.config.BalanceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@RibbonClient(name = "providerName",configuration = {BalanceConfig.class})
public class StartConsumer {
    public static void main(String[] args) {
        System.out.println("启动消费者");
        SpringApplication.run(StartConsumer.class,args);
    }
}
