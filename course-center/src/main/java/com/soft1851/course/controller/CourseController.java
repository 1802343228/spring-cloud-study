package com.soft1851.course.controller;

import com.soft1851.course.common.ResponseResult;
import com.soft1851.course.dto.CourseDto;
import com.soft1851.course.dto.UserDto;
import com.soft1851.course.entity.Course;
import com.soft1851.course.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author crq
 */
@RestController
@RequestMapping(value = "/course")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CourseController {
    private final CourseService courseService;
//    @Autowired
//    public CourseController(CourseService courseService){
//        this.courseService = courseService;
//    }

    private final RestTemplate restTemplate;


    @GetMapping(value = "/all")
    public ResponseResult getAll(){
        List<Course> courses = courseService.findAll();
        List<CourseDto> courseDtoList = new ArrayList<>();
        courses.forEach(course -> {
            int userId = course.getUserId();
            UserDto userDto = restTemplate.getForObject("http://localhost:8081/user/{id}", UserDto.class,userId);
            assert userDto != null;
            CourseDto courseDto = CourseDto.builder().course(course).userName(userDto.getUserName()).avatarUrl(userDto.getAvatarUrl()).build();
            courseDtoList.add(courseDto);
        });
        return new ResponseResult(1,"请求成功",courseDtoList);
    }

    @GetMapping(value = "/python")
    public String getHello(){
        return restTemplate.getForObject("http://localhost:5000/hello",String.class);
    }
}
