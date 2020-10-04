package com.soft1851.content.feignclient;

import com.soft1851.content.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author crq
 */
@FeignClient(name = "user-center")
public interface TestUserCenterFeignClient {
    /**
     * 查询
     * @param userDto
     * @return
     */
    @GetMapping("/user/q")
    UserDto query(@SpringQueryMap UserDto userDto);
//    @RequestMapping(value = "/user/q",method = RequestMethod.GET)
//    UserDto query(@RequestParam("id") Integer id,@RequestParam("wxId") String wxId,
//                  @RequestParam("wxNickname")String wxNickname,
//                  @RequestParam("roles")String roles,
//                  @RequestParam("avatarUrl")String avatarUrl,
//                  @RequestParam("createTime") Date createTime,
//                  @RequestParam("updateTime") Date updateTime,
//                  @RequestParam("bonus") Integer bonus

  //  );
}
