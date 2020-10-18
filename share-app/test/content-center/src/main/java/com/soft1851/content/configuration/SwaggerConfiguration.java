package com.soft1851.content.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/**
 * @author crq
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration{
    private ApiInfo apiInfo() {
        return new ApiInfo(
                "share-app Swagger文档",
                "github地址：https://github.com/1802343228/spring-cloud-study/tree/master/share-app",
                "API V1.0",
                "Terms of service",
                new Contact("crq","https://github.com/1802343228/spring-cloud-study/tree/master/share-app",
                        "2631315464@qq.com"),
                        "Apache","1222", Collections.emptyList());
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.soft1851.content"))
                .build()
                .apiInfo(apiInfo());
    }
}
