package com.yuanzijun.dao.impl;

import com.yuanzijun.dao.StudentDao;
import com.yuanzijun.pojo.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class StudentDaoImpl implements StudentDao {
    private JdbcTemplate jdbcTemplate;

    //注入我们的jdbcTe..对象
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Student> queryAll() {
        //ioc容器进行装配
        String sql = "select id , name , gender , age , class as classes from students";

        List<Student> students = jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Student.class));

        System.out.println("studentDao:" + students);

        return students;
    }
}
