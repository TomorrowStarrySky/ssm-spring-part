package com.yuan.controller;

import com.yuan.pojo.Student;
import com.yuan.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    public void findAll(){
        List<Student> all = studentService.queryAll();
        System.out.println(all);
    }

}
