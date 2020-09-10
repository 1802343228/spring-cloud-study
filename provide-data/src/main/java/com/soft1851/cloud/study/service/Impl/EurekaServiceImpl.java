package com.soft1851.cloud.study.service.Impl;

import com.soft1851.cloud.study.entity.Eureka;
import com.soft1851.cloud.study.mapper.EurekaMapper;
import com.soft1851.cloud.study.service.EurekaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author crq
 */
@Service
public class EurekaServiceImpl implements  EurekaService{
    @Resource
    private EurekaMapper eurekaMapper;

    @Override
    public List<Eureka> selectAll() {
        return null;
    }
}
