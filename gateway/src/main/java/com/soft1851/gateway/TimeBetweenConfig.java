package com.soft1851.gateway;

import lombok.Builder;
import lombok.Data;

import java.time.LocalTime;

/**
 * 定义开始和结束的两个参数
 * @author crq
 */
@Data
@Builder
public class TimeBetweenConfig {
    private LocalTime start;
    private LocalTime end;
}
