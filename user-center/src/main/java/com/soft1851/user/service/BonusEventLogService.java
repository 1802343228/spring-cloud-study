package com.soft1851.user.service;

import com.soft1851.user.entity.BonusEventLog;

import java.util.List;

/**
 * @author crq
 */
public interface BonusEventLogService {
    /**
     * 根据Id找积分
     * @return
     */
    List<BonusEventLog> findEventById();
}
