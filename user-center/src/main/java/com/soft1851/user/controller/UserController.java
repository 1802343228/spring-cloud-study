package com.soft1851.user.controller;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.soft1851.user.common.ResponseResult;
import com.soft1851.user.dto.*;
import com.soft1851.user.entity.User;
import com.soft1851.user.service.UserService;
import com.soft1851.user.util.JwtOperator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author crq
 */
@RestController
@RequestMapping(value = "/user")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {
    private final UserService userService;
    private final JwtOperator jwtOperator;
    private final WxMaService wxMaService;

    @GetMapping(value = "/find/{id}")
    public User findUserById(@PathVariable Integer id){
        log.info("被请求了被请求了");
        log.info(userService.findById(id).getWxNickname());
        return userService.findById(id);
    }

    @PostMapping(value = "/login")
    public LoginResDto getToken(@RequestBody LoginDto loginDto)throws WxErrorException {
        String openId;
        if(loginDto.getLoginCode() != null) {
            WxMaJscode2SessionResult result = this.wxMaService.getUserService()
                    .getSessionInfo(loginDto.getLoginCode());
            log.info(result.toString());
            openId = result.getOpenid();
        }else {
            openId = loginDto.getOpenId();
        }

        User user = userService.login(loginDto,openId);
        Map<String,Object> userInfo = new HashMap<>(3);
        userInfo.put("id",user.getId());
        userInfo.put("wxNickname",user.getWxNickname());
        userInfo.put("role",user.getRoles());
        String token = jwtOperator.generateToken(userInfo);

        log.info(
                "{}登录成功，生成的token={},有效期到:{}",
                user.getWxNickname(),
                token,
                jwtOperator.getExpirationTime()
        );
        return LoginResDto.builder()
                .user(UserResDto.builder()
                        .id(user.getId())
                        .wxNickname(user.getWxNickname())
                        .avatarUrl(user.getAvatarUrl())
                        .bonus(user.getBonus())
                        .build())
                .token(JwtTokenRespDto.builder()
                        .token(token)
                        .expirationTime(jwtOperator.getExpirationTime().getTime())
                        .build())
                .build();
    }

    @PostMapping("/bonus/new")
    public ResponseResult addBonus(@RequestBody UserAddBonusMsgDto userAddBonusMsgDto) {
        System.out.println("添加一条积分记录");
        return ResponseResult.builder().code(userService.addBonus(userAddBonusMsgDto)).build();
    }
    @GetMapping("/q")
    public User query(User user){
        return user;
    }
}
