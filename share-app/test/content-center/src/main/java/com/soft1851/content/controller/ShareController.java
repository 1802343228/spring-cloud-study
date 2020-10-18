package com.soft1851.content.controller;

import com.alibaba.nacos.common.utils.StringUtils;
import com.soft1851.content.dto.ExchangeDto;
import com.soft1851.content.dto.ShareContributeDto;
import com.soft1851.content.dto.ShareDto;
import com.soft1851.content.entity.Share;
import com.soft1851.content.service.ShareService;
import com.soft1851.content.util.JwtOperator;
import io.jsonwebtoken.Claims;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * @author crq
 */
@Slf4j
@RestController
@RequestMapping(value = "/share")
@Api(tags = "分享接口",value = "提供分享相关的Rest API")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ShareController {
    private final ShareService shareService;
    private final JwtOperator jwtOperator;

    @GetMapping(value = "/all")
    @ApiOperation(value = "查询所有分享",notes = "查询所有分享")
    public List<Share> findAll() {
        return shareService.findAll() ;
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "查询指定id的分享详情",notes = "查询指定Id的分享详情")
    public ShareDto findById(@PathVariable Integer id) {
        return this.shareService.findById(id);
    }

    @GetMapping(value = "/query")
    @ApiOperation(value = "分享列表",notes = "分享列表")
    public List<Share> query(
            @RequestParam(required = false)String title,
            @RequestParam(required = false,defaultValue = "1")Integer pageNo,
            @RequestParam(required = false,defaultValue = "10")Integer pageSize,
            @RequestHeader(value = "X-Token", required = false) String token) {
        if (pageSize > 100) {
            pageSize = 100;
        }
        Integer userId = null;
//        if (!"no-token".equals(token)) {
//            Claims claims = this.jwtOperator.getClaimsFromToken(token);
//            log.info(claims.toString());
//            userId = (Integer) claims.get("id");
//        } else {
//            log.info("没有token");
//        }
//        return this.shareService.query(title, pageNo, pageSize, userId).getList();

        if (StringUtils.isNotBlank(token)) {
            System.out.println(token);
            Claims claims = this.jwtOperator.getClaimsFromToken(token);
            log.info(claims.toString());
            userId = (Integer) claims.get("id");
        } else {
            log.info("没有token");
        }
        return this.shareService.query(title, pageNo, pageSize, userId).getList();

    }

    @PostMapping (value = "/contribute")
    @ApiOperation(value = "投稿",notes = "投稿")
    public int putShare(@RequestBody ShareContributeDto shareContributeDto) {
        return shareService.putShare(shareContributeDto);
    }

    @PostMapping("/exchange")
    //@CheckLogin
    public Share exchange(@RequestBody ExchangeDto exchangeDto) {
        System.out.println(exchangeDto + ">>>>>>>>>>>>");
        return this.shareService.exchange(exchangeDto);
    }

    @GetMapping(value = "/hello")
    @ApiIgnore
    public String getHello(){
        return shareService.getHello();
    }
}
