package com.soft1851.content.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author crq
 */
@RestController
@RequestMapping(value = "/content")
public class ContentHello {
    @Resource
    private RestTemplate restTemplate;
    @GetMapping(value = "/call")
    public  String getHello(){
        return restTemplate.getForObject("http://localhost:8002/user/hello",String.class);
    }
}
