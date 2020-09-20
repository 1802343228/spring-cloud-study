package com.soft1851.cloud.study.controller;

import com.soft1851.cloud.study.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author crq
 */

@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @GetMapping(value = "/one")
    public Student getOneStudent(){
        return new Student(101,"Tom");
    }

    @GetMapping(value = "/list")
    public List<Student> getStudentList(){
        Student[] students = new Student[]{
                new Student(101,"马云"),
                new Student(101,"雷军"),
                new Student(101,"马化腾"),
        };
        return Arrays.asList(students);
    }
}
