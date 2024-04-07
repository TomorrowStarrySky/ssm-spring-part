package com.yuanzijun.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import com.yuanzijun.controller.StudentController;
import com.yuanzijun.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcTemplateTest {
    public void testForJava() {
        /*
        jdbcTemplate 简化数据库的crud 不提供连接池
        DruidDataSource 负责连接的创建和数据库驱动的注册等
         */

        //0.创建一个连接池对象
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql:///studb");//连接的库url地址
        dataSource.setDriverClassName("com.mysql.cj.jdbc,Driver");//jdbc驱动
        dataSource.setUsername("root");//账号名
        dataSource.setPassword("zyj881908421");//密码

        //1.实例化对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate();

        //2.调用方法
//        jdbcTemplate.update(); DDL DML DCL...非查询语句
//        jdbcTemplate.queryForObject(); DQL 查询单个对象
//        jdbcTemplate.query(); DQL 查询集合

    }

    //通过ioc容器获取配置的组件
    @Test
    public void testForIoc() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-01.xml");

        JdbcTemplate jdbcTemplate = applicationContext.getBean(JdbcTemplate.class);

        String sql = "insert into students (id,name,gender,age,class) values (?,?,?,?,?)";

        //String sql 可以带占位符 ？ ？可以替代值，不能替代关键字和容器名
        //Object...param 传入占位符的值 顺序由左开始
        int rows = jdbcTemplate.update(sql, 6,"袁子俊", "男", 21, "三年一班");
        System.out.println("rows:" + rows);

        //查询单条数据
        sql = "select * from students where id = ?";
        /**
         * 参数1：sql语句
         * 参数2：RowMapper 列名和属性名的映射器接口
         * 参数3：Object...param 占位符的值
         */
        Student student1 = jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            //rs 结果集
            //rowNum 行数
            //从rs结果集获取的值 赋给实体类

            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setAge(rs.getInt("age"));
            student.setGender(rs.getString("gender"));
            student.setClasses(rs.getString("class"));
            return student;
        }, 1);

        //查询所有学生数据
        sql = "select id , name , gender , age ,class as classes from students";
        List<Student> studentList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class));
        System.out.println("studentList" + studentList);
    }

    /**
     * 从ioc容器获取controller并调用业务
     */
    @Test
    public void testQueryAll(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-02.xml");

        StudentController controller = applicationContext.getBean(StudentController.class);

        controller.findAll();

        applicationContext.close();

    }
}
