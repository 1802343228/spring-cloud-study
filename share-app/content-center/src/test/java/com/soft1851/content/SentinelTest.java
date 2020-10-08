package com.soft1851.content;

import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

public class SentinelTest {
    public static void main(String[] args) throws InterruptedException {
        RestTemplate restTemplate = new RestTemplate();
        for(int i = 0;i<10;i++) {
            //String object = restTemplate.getForObject("http://localhost:8888/notice/one",String.class);
            String object = restTemplate.getForObject("http://localhost:8888/test/byResource",String.class);
            System.out.println(object);
            System.out.println("ok");
            //Thread.sleep(200);
        }
    }
}