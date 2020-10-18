package com.soft1851.usercenter.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BonusEventLogServiceTest {

    @Resource
    private BonusEventLogService bonusEventLogService;
    @Test
    void findEventById() {
        System.out.println(bonusEventLogService.findEventById(7));
    }
}