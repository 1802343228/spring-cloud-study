package com.soft1851.user.controller;

import com.soft1851.user.entity.BonusEventLog;
import com.soft1851.user.service.BonusEventLogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author crq
 */
@RestController
@RequestMapping(value = "/bonus")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BonusEventLogController {
    private final BonusEventLogService bonusEventLogService;

    @GetMapping()
    public List<BonusEventLog> findBonusEvent(){
        return bonusEventLogService.findEventById();
    }
}
