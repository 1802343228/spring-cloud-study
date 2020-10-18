package com.soft1851.usercenter.service.impl;

import com.soft1851.usercenter.dao.BonusEventLogMapper;
import com.soft1851.usercenter.dao.UserMapper;
import com.soft1851.usercenter.domain.dto.*;
import com.soft1851.usercenter.domain.entity.BonusEventLog;
import com.soft1851.usercenter.domain.entity.User;
import com.soft1851.usercenter.service.UserService;
import com.soft1851.usercenter.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @author zhao
 * @className UserServiceImpl
 * @Description TODO
 * @Date 2020/9/29
 * @Version 1.0
 **/
@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final BonusEventLogMapper bonusEventLogMapper;

    @Override
    public User findById(Integer id) {
        return this.userMapper.selectByPrimaryKey(id);

    }

    @Override
    public ResponseDTO signIn(UserSignInDto signInDto) {
        User user = this.userMapper.selectByPrimaryKey(signInDto.getUserId());
        if(user == null) {
            throw new IllegalArgumentException("该用户不存在");
        }
        Example example = new Example(BonusEventLog.class);
        Example.Criteria criteria = example.createCriteria();
        example.setOrderByClause("id DESC");
        criteria.andEqualTo("userId",signInDto.getUserId());
        criteria.andEqualTo("event","SIGN_IN");
        List<BonusEventLog> bonusEventLogs = this.bonusEventLogMapper.selectByExample(example);
        if(bonusEventLogs.size() != 0) {
            BonusEventLog bonusEventLog = bonusEventLogs.get(0);
            Date date = bonusEventLog.getCreateTime();
            try {
                if (DateUtil.checkAllotSign(date) == 0) {
                    user.setBonus(user.getBonus() + 20);
                    this.userMapper.updateByPrimaryKeySelective(user);

                    this.bonusEventLogMapper.insert(BonusEventLog.builder()
                            .userId(signInDto.getUserId())
                            .event("SIGN_IN")
                            .value(20)
                            .description("签到加积分")
                            .createTime(new Date())
                            .build());
                    return new ResponseDTO(true, "200", "签到成功", user.getWxNickname() + "用户签到成功", 1L);
                } else if (DateUtil.checkAllotSign(date) == 1) {
                    return new ResponseDTO(false, "201", "签到失败", user.getWxNickname() + "今天已经签到过了", 1L);
                } else if (DateUtil.checkAllotSign(date) == 2) {
                    return new ResponseDTO(false, "201", "签到失败", user.getWxNickname() + "用户，今天数据错乱了", +1L);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            user.setBonus(user.getBonus() + 20);
            this.userMapper.updateByPrimaryKeySelective(user);
            this.bonusEventLogMapper.insert(BonusEventLog.builder()
                    .userId(signInDto.getUserId())
                    .event("SIGN_IN")
                    .value(20)
                    .description("签到加积分")
                    .createTime(new Date())
                    .build());
            return new ResponseDTO(true, "200", "签到成功", user.getWxNickname() + "用户签到成功", 1L);
        }
        return new ResponseDTO(true,"200","签到成功",user.getWxNickname()+"签到成功", 1L);
    }

    @Override
    public ResponseDTO checkIsSign(UserSignInDto signInDto) {
        User user = this.userMapper.selectByPrimaryKey(signInDto.getUserId());
        if(user == null) {
            throw new IllegalArgumentException("该用户不存在");
        }
        Example example = new Example(BonusEventLog.class);
        Example.Criteria criteria = example.createCriteria();
        example.setOrderByClause("id DESC");
        criteria.andEqualTo("userId",signInDto.getUserId());
        criteria.andEqualTo("event","SIGN_IN");
        List<BonusEventLog> bonusEventLogs = this.bonusEventLogMapper.selectByExample(example);
        System.out.println(bonusEventLogs);
        if(bonusEventLogs.size() != 0) {
           BonusEventLog bonusEventLog = bonusEventLogs.get(0);
           System.out.println(bonusEventLogs.get(0));
           Date date = bonusEventLog.getCreateTime();

        try {
            if(DateUtil.checkAllotSign(date) == 0) {
                //CheckSignInDTO checkSignInDTO = CheckSignInDTO.builder().isUserSignIn(1).build();
                return new ResponseDTO(true,"200","该用户还没有签到","可以签到", 1L);
            }
            else if(DateUtil.checkAllotSign(date) == 1) {
                return new ResponseDTO(false,"201","已经签到了","不可以签到",1L);
            }
            else if(DateUtil.checkAllotSign(date) == 2) {
                return new ResponseDTO(false,"201","数据出错了","不可以签到",+1L);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       }else {
            return new ResponseDTO(true,"200","该用户还没有签到","可以签到", 1L);
        }
        return new ResponseDTO(true,"200","该用户还没有签到","可以签到", 1L);
    }

    @Override
    public int addBonus(UserAddBonusMsgDTO userAddBonusMsgDTO) {
        Integer userId = userAddBonusMsgDTO.getUserId();
        System.out.println(userId);
        User user = this.userMapper.selectByPrimaryKey(userId);
        user.setBonus(user.getBonus() + userAddBonusMsgDTO.getBonus());
        this.userMapper.updateByPrimaryKeySelective(user);
        return this.bonusEventLogMapper.insert(BonusEventLog.builder()
                .userId(userId)
                .value(userAddBonusMsgDTO.getBonus())
                .event("CONTRIBUTE")
                .description("投稿加积分")
                .createTime(Timestamp.valueOf(LocalDateTime.now()))
                .build());

    }

    @Override
    public User login(LoginDTO loginDTO) {
        //先根据wxId查找用户
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("wxId", loginDTO.getOpenId());
        List<User> users = this.userMapper.selectByExample(example);
        //没找到，是新用户，直接注册
        if (users.size() == 0) {
            User saveUser = User.builder()
                    .wxId(loginDTO.getOpenId())
                    .avatarUrl(loginDTO.getAvatarUrl())
                    .wxNickname(loginDTO.getWxNickname())
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
}
