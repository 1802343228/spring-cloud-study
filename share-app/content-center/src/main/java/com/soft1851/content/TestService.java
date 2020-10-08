package com.soft1851.content;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author crq
 */
@Service
@Slf4j
public class TestService {
    /**
     * 指定sentinel的资源名称
     * @return
     */
    @SentinelResource("common")
    public String commonMethod() {
        log.info("commonMethod....");
        return "common";
    }
}
