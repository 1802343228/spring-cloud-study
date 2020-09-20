package com.soft1851.cloud.study.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author crq
 */
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Student {
    private Integer id;
    private String name;
}
