package com.soft1851.user.rocketmq;

import com.soft1851.user.dto.UserAddBonusMsgDto;
import com.soft1851.user.entity.BonusEventLog;
import com.soft1851.user.entity.User;
import com.soft1851.user.mapper.BonusEventLogMapper;
import com.soft1851.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Date;


/**
 * @author crq
 */
@Service
@RocketMQMessageListener(consumerGroup = "consumer",topic = "add-bonus")
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
@Profile("consumer")
public class AddBonusListener implements RocketMQListener<UserAddBonusMsgDto> {

    private final UserMapper userMapper;
    private final BonusEventLogMapper bonusEventLogMapper;

    @Override
    public void onMessage(UserAddBonusMsgDto userAddBonusMsgDto) {
        //为用户加积分
        Integer userId = userAddBonusMsgDto.getUserId();
        User user = this.userMapper.selectByPrimaryKey(userId);
        user.setBonus(user.getBonus() + userAddBonusMsgDto.getBonus());
        this.userMapper.updateByPrimaryKeySelective(user);
        //写积分日志
        this.bonusEventLogMapper.insert(BonusEventLog.builder()
                .userId(userId)
                .value(userAddBonusMsgDto.getBonus())
                .event("CONTRIBUTE")
                .createTime(new Date())
                .description("投稿加积分")
                .build()
        );
    }
}
