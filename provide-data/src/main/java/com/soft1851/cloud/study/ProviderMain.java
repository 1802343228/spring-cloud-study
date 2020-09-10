package com.soft1851.cloud.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author crq
 */
@SpringBootApplication
@EnableDiscoveryClient//官方通用
public class ProviderMain {
    public static void main(String[] args) {
        SpringApplication.run(ProviderMain.class,args);
    }
}
