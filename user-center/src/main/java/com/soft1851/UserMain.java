package com.soft1851;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author crq
 */

@SpringBootApplication
@MapperScan(basePackages = "com.soft1851.mapper")
public class UserMain {

    public static void main(String[] args) {
        SpringApplication.run(UserMain.class, args);
    }
}
