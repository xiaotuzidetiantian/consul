package com.wxf.sc;

import com.wxf.sc.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({MyConfig.class})
public class StartConfig {
    public static void main(String[] args) {
        System.out.println("config启动");
        SpringApplication.run(StartConfig.class,args);
    }
}
