package com.soft1851.cloud.study.service;

import com.soft1851.cloud.study.entity.Eureka;

import java.util.List;

/**
 * @author crq
 */
public interface EurekaService {
    /**
     * 查询
     * @return
     */
    List<Eureka> selectAll();
}
