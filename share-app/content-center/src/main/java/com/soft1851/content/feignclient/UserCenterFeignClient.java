package com.soft1851.content.feignclient;

import com.soft1851.content.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author crq
 */
//@FeignClient(name = "user-center",configuration = UserCenterFeignConfiguration.class)
@FeignClient(name = "user-center")
public interface UserCenterFeignClient {

    /**
     * 根据Id找用户
     * @param id
     * @return
     */
    @GetMapping("/user/find/{id}")
    UserDto findUserById(@PathVariable Integer id);

    /**
     * 测试
     * @return
     */
    @GetMapping("/user/hello")
    String getHello();
}
