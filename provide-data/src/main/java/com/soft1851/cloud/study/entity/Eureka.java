package com.soft1851.cloud.study.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author crq
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Eureka {
    private String id;
    private String name;
}
