package com.soft1851.course.dto;

import com.soft1851.course.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author crq
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseDto {
    private Course course;
    private String userName;
    private String avatarUrl;
}
