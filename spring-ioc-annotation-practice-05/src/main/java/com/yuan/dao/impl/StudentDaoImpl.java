package com.yuan.dao.impl;

import com.yuan.dao.StudentDao;
import com.yuan.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Student> queryAll() {
        //ioc容器进行装配
        String sql = "select id , name , gender , age , class as classes from students";

        List<Student> students = jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Student.class));

        return students;
    }
}
