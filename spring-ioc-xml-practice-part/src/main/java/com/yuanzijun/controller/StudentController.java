package com.yuanzijun.controller;


import com.yuanzijun.pojo.Student;
import com.yuanzijun.service.StudentService;

import java.util.List;

public class StudentController {
    private StudentService studentService;

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public void findAll(){
        List<Student> all = studentService.findAll();
        System.out.println("最终学生列表：" + all);
    }
}
