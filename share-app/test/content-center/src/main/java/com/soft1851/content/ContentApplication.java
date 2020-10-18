package com.soft1851.content;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author crq
 */
@SpringBootApplication
//@EnableGlobalDispose
@MapperScan("com.soft1851.content.mapper")
@EnableFeignClients//(defaultConfiguration = GlobalFeignConfiguration.class)
public class ContentApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContentApplication.class, args);
    }

//    @Bean
//    public AsyncRestTemplate asyncRestTemplate() {
//        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
//        //设置链接超时时间
//        factory.setConnectTimeout(100);
//        //设置读取资料超时时间
//        factory.setReadTimeout(200);
//        //设置异步任务（线程不会重用，每次调用时都会重新启动一个新的线程）
//        factory.setTaskExecutor(new SimpleAsyncTaskExecutor());
//        return new AsyncRestTemplate(factory);
//    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
