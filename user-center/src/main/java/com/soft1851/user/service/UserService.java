package com.soft1851.user.service;

import com.soft1851.user.dto.LoginDto;
import com.soft1851.user.dto.UserAddBonusMsgDto;
import com.soft1851.user.entity.User;

/**
 * @author crq
 */
public interface UserService {
    /**
     *根据id查询用户
     * @param id
     * @return
     */
    User findById(Integer id);

    /**
     * 登录
     * @param loginDto
     * @param openId
     * @return
     */
    User login(LoginDto loginDto,String openId);
    /**
     * 添加一条积分记录
     * @param userAddBonusMsgDto
     * @return
     */
    int addBonus(UserAddBonusMsgDto userAddBonusMsgDto);
}
