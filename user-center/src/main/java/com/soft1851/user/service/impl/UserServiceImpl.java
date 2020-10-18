package com.soft1851.user.service.impl;

import com.soft1851.user.dto.LoginDto;
import com.soft1851.user.dto.UserAddBonusMsgDto;
import com.soft1851.user.entity.BonusEventLog;
import com.soft1851.user.entity.User;
import com.soft1851.user.mapper.BonusEventLogMapper;
import com.soft1851.user.mapper.UserMapper;
import com.soft1851.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @author crq
 */
@Service
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final BonusEventLogMapper bonusEventLogMapper;

    @Override
    public User findById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public User login(LoginDto loginDto, String openId) {

            Example example = new Example(User.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("wxId",openId);
            List<User> users = this.userMapper.selectByExample(example);
            if(users.size() == 0) {
                User saveUser = User.builder()
                        .wxId(openId)
                        .avatarUrl(loginDto.getAvatarUrl())
                        .wxNickname(loginDto.getWxNickname())
                        .roles("user")
                        .bonus(100)
                        .createTime(new Date())
                        .updateTime(new Date())
                        .build();
                this.userMapper.insertSelective(saveUser);
                return saveUser;
            }
            return users.get(0);
        }




    @Override
    public int addBonus(UserAddBonusMsgDto userAddBonusMsgDto) {
        Integer userId = userAddBonusMsgDto.getUserId();
        System.out.println(userId);
        User user = this.userMapper.selectByPrimaryKey(userId);
        user.setBonus(user.getBonus() + userAddBonusMsgDto.getBonus());
        this.userMapper.updateByPrimaryKeySelective(user);
        return this.bonusEventLogMapper.insert(BonusEventLog.builder()
                .userId(userId)
                .value(userAddBonusMsgDto.getBonus())
                .event("CONTRIBUTE")
                .description("投稿加积分")
                .createTime(Timestamp.valueOf(LocalDateTime.now()))
                .build());

    }
}
