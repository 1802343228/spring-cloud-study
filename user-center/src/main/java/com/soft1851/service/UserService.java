package com.soft1851.service;

import com.soft1851.dto.UserDto;
import com.soft1851.entity.User;
import com.soft1851.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author crq
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {

    private final UserMapper userMapper;

    public UserDto getUserDto(int id){
        User user = userMapper.selectByPrimaryKey(id);
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUserName(user.getUserName());
        userDto.setAvatarUrl(user.getAvatarUrl());
        return userDto;
    }
}
