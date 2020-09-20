package com.soft1851.course.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author crq
 */
@Table(name = "t_course")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    /**
     * strategy 设置使用数据库主键自增策略；generator 设置插入完成后，查询最后生成的 ID 填充到该属性中。
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;


    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "cover")
    private String cover;

    @Column(name = "finished")
    private Short finished;

    /**
     * 课程名称
     */
    @Column(name = "class_name")
    private String className;
}
