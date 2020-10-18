package com.soft1851.usercenter.service;

import com.soft1851.usercenter.domain.entity.BonusEventLog;

import java.util.List;

/**
 * @author crq
 */
public interface BonusEventLogService {
    /**
     * 跟据Id找积分
     * @param userId
     * @return
     */
    List<BonusEventLog> findEventById(Integer userId);
}
