package com.soft1851.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author crq
 */
@SpringBootApplication
@MapperScan(basePackages = "com.soft1851.course.mapper")
public class CourseMain {
    public static void main(String[] args) {
        SpringApplication.run(CourseMain.class, args);
    }
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
