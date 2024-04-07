package com.yuan.service.impl;

import com.yuan.dao.StudentDao;
import com.yuan.pojo.Student;
import com.yuan.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> queryAll() {
        List<Student> studentList = studentDao.queryAll();
        return studentList;
    }

}
