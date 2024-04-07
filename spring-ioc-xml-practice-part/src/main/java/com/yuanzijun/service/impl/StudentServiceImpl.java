package com.yuanzijun.service.impl;

import com.yuanzijun.dao.StudentDao;
import com.yuanzijun.pojo.Student;
import com.yuanzijun.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public List<Student> findAll() {
        List<Student> studentList = studentDao.queryAll();
        System.out.println("studentService:" + studentList);

        return studentList;
    }
}
