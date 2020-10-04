package com.soft1851.user.controller;

import com.soft1851.user.entity.User;
import com.soft1851.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author crq
 */
@RestController
@RequestMapping(value = "/user")
@Slf4j
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping(value = "/find/{id}")
    public User findUserById(@PathVariable Integer id){
        log.info("被请求了被请求了");
        log.info(userService.findById(id).getWxNickname());
        return userService.findById(id);
    }

    @GetMapping("/q")
    public User query(User user){
        return user;
    }
}
