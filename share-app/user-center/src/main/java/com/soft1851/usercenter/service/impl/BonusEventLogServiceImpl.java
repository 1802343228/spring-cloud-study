package com.soft1851.usercenter.service.impl;


import com.soft1851.usercenter.dao.BonusEventLogMapper;
import com.soft1851.usercenter.domain.entity.BonusEventLog;
import com.soft1851.usercenter.service.BonusEventLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author crq
 */
@Service
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class BonusEventLogServiceImpl implements BonusEventLogService {
    private final BonusEventLogMapper bonusEventLogMapper;

    @Override
    public List<BonusEventLog> findEventById(Integer userId) {
        Example example = new Example(BonusEventLog.class);
        Example.Criteria criteria = example.createCriteria();
        example.setOrderByClause("id DESC");
        criteria.andEqualTo("userId",userId);
        List<BonusEventLog> bonusEventLogs = this.bonusEventLogMapper.selectByExample(example);
        return bonusEventLogs;
    }
}
