package com.soft1851.user.service.impl;

import com.soft1851.user.entity.BonusEventLog;
import com.soft1851.user.mapper.BonusEventLogMapper;
import com.soft1851.user.service.BonusEventLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author crq
 */
@Service
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class BonusEventLogServiceImpl implements BonusEventLogService {
    private final BonusEventLogMapper bonusEventLogMapper;

    @Override
    public List<BonusEventLog> findEventById() {
        return bonusEventLogMapper.selectAll();
    }
}
