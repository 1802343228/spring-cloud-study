package com.soft1851.cloud.study.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author crq
 */
@RestController
@RequestMapping(value = "/hello")
public class HelloController {
    @GetMapping()
    public String getHello() {
        return "Hello String Cloud";
    }

}
