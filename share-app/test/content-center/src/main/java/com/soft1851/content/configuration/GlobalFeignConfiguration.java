package com.soft1851.content.configuration;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * @author crq
 */
public class GlobalFeignConfiguration {
        @Bean
        public Logger.Level level(){
            // 让feign打印所有请求的细节
            return Logger.Level.FULL;

    }
}
