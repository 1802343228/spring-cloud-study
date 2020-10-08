package com.soft1851;

import com.soft1851.starter.Md5Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author crq
 */
@RestController
public class TestController {
    @Resource
    private Md5Service md5Service;

    @RequestMapping("/test")
    public String getMd5() {
        return "MD5加密结果为：" + md5Service.getMd5("myPassword");
    }
}
