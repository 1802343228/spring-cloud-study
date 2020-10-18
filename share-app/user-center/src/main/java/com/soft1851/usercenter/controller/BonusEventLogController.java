package com.soft1851.usercenter.controller;

import com.soft1851.usercenter.domain.entity.BonusEventLog;
import com.soft1851.usercenter.service.BonusEventLogService;
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

    @GetMapping("/find")
    public List<BonusEventLog> findBonusEvent(Integer id){
        return bonusEventLogService.findEventById(id);
    }
}
