package com.soft1851.user.service;

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
}
