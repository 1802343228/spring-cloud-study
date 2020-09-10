package com.soft1851.cloud.study.controller;

import com.soft1851.cloud.study.entity.Eureka;
import com.soft1851.cloud.study.mapper.EurekaMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author crq
 */
@RestController
@RequestMapping(value = "/search")
public class Controller {
    @Resource
    private EurekaMapper eurekaMapper;

    @GetMapping()
    public List<Eureka> selectAll() {
        return eurekaMapper.selectAll();
    }

}
