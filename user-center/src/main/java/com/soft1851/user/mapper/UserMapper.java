package com.soft1851.user.mapper;

import com.soft1851.user.entity.User;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author crq
 */
@Component
public interface UserMapper extends Mapper<User> {
}
